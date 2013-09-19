package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AcceptedStateFacade{

	private String schemaName;
	private Connection con;

	public AcceptedStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AcceptedStateProxi getTheAcceptedState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccptdSttFacade.getTheAccptdStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (AcceptedStateProxi)PersistentProxi.createProxi(id, 265);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AcceptedState getAcceptedState(long AcceptedStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccptdSttFacade.getAccptdStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AcceptedStateId);
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
            AcceptedState result = new AcceptedState(subService, 
                                                     This, 
                                                     AcceptedStateId);
            links.close();
            callable.close();
            AcceptedStateICProxi inCache = (AcceptedStateICProxi)Cache.getTheCache().put(result);
            AcceptedState objectInCache = (AcceptedState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

