package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompensationRequestedStateFacade{

	private String schemaName;
	private Connection con;

	public CompensationRequestedStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompensationRequestedStateProxi newCompensationRequestedState(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CompReqStaFacade.newCompReqSta(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationRequestedState result = new CompensationRequestedState(null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationRequestedStateProxi)PersistentProxi.createProxi(id, 283);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationRequestedStateProxi newDelayedCompensationRequestedState() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CompReqStaFacade.newDelayedCompReqSta(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationRequestedState result = new CompensationRequestedState(null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationRequestedStateProxi)PersistentProxi.createProxi(id, 283);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationRequestedState getCompensationRequestedState(long CompensationRequestedStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CompReqStaFacade.getCompReqSta(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensationRequestedStateId);
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
            CompensationRequestedState result = new CompensationRequestedState(subService,
                                                                               This,
                                                                               CompensationRequestedStateId);
            obj.close();
            callable.close();
            CompensationRequestedStateICProxi inCache = (CompensationRequestedStateICProxi)Cache.getTheCache().put(result);
            CompensationRequestedState objectInCache = (CompensationRequestedState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

