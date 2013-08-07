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

    public ExecutedStateProxi getTheExecutedState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctdSttFacade.getTheExctdStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
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
            ExecutedState result = new ExecutedState(subService,
                                                     This,
                                                     ExecutedStateId);
            obj.close();
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

