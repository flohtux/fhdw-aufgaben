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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentCompensationRequestState This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10389: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10390: {
                        This = (PersistentCompensationRequestState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            WaitingState result = new WaitingState(subService, 
                                                   This, 
                                                   WaitingStateId);
            links.close();
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

