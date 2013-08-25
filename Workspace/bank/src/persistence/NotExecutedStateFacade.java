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

    public NotExecutedStateProxi getTheNotExecutedState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctdSttFacade.getTheNtExctdStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
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
            NotExecutedState result = new NotExecutedState(subService,
                                                           This,
                                                           NotExecutedStateId);
            obj.close();
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

