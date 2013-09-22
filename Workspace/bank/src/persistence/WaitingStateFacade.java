package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class WaitingStateFacade{

	private String schemaName;
	private Connection con;

	public WaitingStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public WaitingStateProxi getTheWaitingState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".WtngSttFacade.getTheWtngStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (WaitingStateProxi)PersistentProxi.createProxi(id, 263);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public WaitingState getWaitingState(long WaitingStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".WtngSttFacade.getWtngStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, WaitingStateId);
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
            PersistentCompensationRequestState This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentCompensationRequestState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            WaitingState result = new WaitingState(subService,
                                                   This,
                                                   WaitingStateId);
            obj.close();
            callable.close();
            WaitingStateICProxi inCache = (WaitingStateICProxi)Cache.getTheCache().put(result);
            WaitingState objectInCache = (WaitingState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

