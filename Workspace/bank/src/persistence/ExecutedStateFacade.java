package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class ExecutedStateFacade{

	private String schemaName;
	private Connection con;

	public ExecutedStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ExecutedStateProxi newExecutedState(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctdSttFacade.newExctdStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ExecutedState result = new ExecutedState(null,null,id);
            Cache.getTheCache().put(result);
            return (ExecutedStateProxi)PersistentProxi.createProxi(id, 110);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ExecutedStateProxi newDelayedExecutedState() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctdSttFacade.newDelayedExctdStt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ExecutedState result = new ExecutedState(null,null,id);
            Cache.getTheCache().put(result);
            return (ExecutedStateProxi)PersistentProxi.createProxi(id, 110);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ExecutedState getExecutedState(long ExecutedStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctdSttFacade.getExctdStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ExecutedStateId);
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
            ExecutedState result = new ExecutedState(subService, 
                                                     This, 
                                                     ExecutedStateId);
            links.close();
            callable.close();
            ExecutedStateICProxi inCache = (ExecutedStateICProxi)Cache.getTheCache().put(result);
            ExecutedState objectInCache = (ExecutedState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

