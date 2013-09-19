package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DeclinedStateFacade{

	private String schemaName;
	private Connection con;

	public DeclinedStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DeclinedStateProxi getTheDeclinedState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DclndSttFacade.getTheDclndStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (DeclinedStateProxi)PersistentProxi.createProxi(id, 266);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DeclinedState getDeclinedState(long DeclinedStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DclndSttFacade.getDclndStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DeclinedStateId);
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
            DeclinedState result = new DeclinedState(subService, 
                                                     This, 
                                                     DeclinedStateId);
            links.close();
            callable.close();
            DeclinedStateICProxi inCache = (DeclinedStateICProxi)Cache.getTheCache().put(result);
            DeclinedState objectInCache = (DeclinedState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

