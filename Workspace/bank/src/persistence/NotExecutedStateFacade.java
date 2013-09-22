package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NotExecutedStateFacade{

	private String schemaName;
	private Connection con;

	public NotExecutedStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NotExecutedStateProxi newNotExecutedState(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctdSttFacade.newNtExctdStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NotExecutedState result = new NotExecutedState(null,null,id);
            Cache.getTheCache().put(result);
            return (NotExecutedStateProxi)PersistentProxi.createProxi(id, 210);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotExecutedStateProxi newDelayedNotExecutedState() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctdSttFacade.newDelayedNtExctdStt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NotExecutedState result = new NotExecutedState(null,null,id);
            Cache.getTheCache().put(result);
            return (NotExecutedStateProxi)PersistentProxi.createProxi(id, 210);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotExecutedState getNotExecutedState(long NotExecutedStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctdSttFacade.getNtExctdStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NotExecutedStateId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentDebitTransferState This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10092: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10093: {
                        This = (PersistentDebitTransferState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            NotExecutedState result = new NotExecutedState(subService, 
                                                           This, 
                                                           NotExecutedStateId);
            links.close();
            callable.close();
            NotExecutedStateICProxi inCache = (NotExecutedStateICProxi)Cache.getTheCache().put(result);
            NotExecutedState objectInCache = (NotExecutedState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

