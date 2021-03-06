package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NotExecutableStateFacade{

	private String schemaName;
	private Connection con;

	public NotExecutableStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NotExecutableStateProxi newNotExecutableState(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctblSttFacade.newNtExctblStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NotExecutableState result = new NotExecutableState(null,null,id);
            Cache.getTheCache().put(result);
            return (NotExecutableStateProxi)PersistentProxi.createProxi(id, 144);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotExecutableStateProxi newDelayedNotExecutableState() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctblSttFacade.newDelayedNtExctblStt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NotExecutableState result = new NotExecutableState(null,null,id);
            Cache.getTheCache().put(result);
            return (NotExecutableStateProxi)PersistentProxi.createProxi(id, 144);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotExecutableState getNotExecutableState(long NotExecutableStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctblSttFacade.getNtExctblStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NotExecutableStateId);
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
            NotExecutableState result = new NotExecutableState(subService,
                                                               This,
                                                               NotExecutableStateId);
            obj.close();
            callable.close();
            NotExecutableStateICProxi inCache = (NotExecutableStateICProxi)Cache.getTheCache().put(result);
            NotExecutableState objectInCache = (NotExecutableState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

