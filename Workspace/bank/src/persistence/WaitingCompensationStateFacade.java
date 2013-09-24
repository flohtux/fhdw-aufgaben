package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class WaitingCompensationStateFacade{

	private String schemaName;
	private Connection con;

	public WaitingCompensationStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public WaitingCompensationStateProxi getTheWaitingCompensationState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".WaitComStaFacade.getTheWaitComSta; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (WaitingCompensationStateProxi)PersistentProxi.createProxi(id, 278);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public WaitingCompensationState getWaitingCompensationState(long WaitingCompensationStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".WaitComStaFacade.getWaitComSta(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, WaitingCompensationStateId);
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
            PersistentCompensationState This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentCompensationState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            WaitingCompensationState result = new WaitingCompensationState(subService,
                                                                           This,
                                                                           WaitingCompensationStateId);
            obj.close();
            callable.close();
            WaitingCompensationStateICProxi inCache = (WaitingCompensationStateICProxi)Cache.getTheCache().put(result);
            WaitingCompensationState objectInCache = (WaitingCompensationState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

