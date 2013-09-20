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
            DeclinedState result = new DeclinedState(subService,
                                                     This,
                                                     DeclinedStateId);
            obj.close();
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

