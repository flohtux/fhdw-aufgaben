package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompensatedStateFacade{

	private String schemaName;
	private Connection con;

	public CompensatedStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompensatedStateProxi newCompensatedState(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstdSttFacade.newCmpnstdStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensatedState result = new CompensatedState(null,null,id);
            Cache.getTheCache().put(result);
            return (CompensatedStateProxi)PersistentProxi.createProxi(id, 282);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensatedStateProxi newDelayedCompensatedState() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstdSttFacade.newDelayedCmpnstdStt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensatedState result = new CompensatedState(null,null,id);
            Cache.getTheCache().put(result);
            return (CompensatedStateProxi)PersistentProxi.createProxi(id, 282);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensatedState getCompensatedState(long CompensatedStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstdSttFacade.getCmpnstdStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensatedStateId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentDebitTransferState This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentDebitTransferState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            CompensatedState result = new CompensatedState(subService,
                                                           This,
                                                           CompensatedStateId);
            obj.close();
            callable.close();
            CompensatedStateICProxi inCache = (CompensatedStateICProxi)Cache.getTheCache().put(result);
            CompensatedState objectInCache = (CompensatedState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

