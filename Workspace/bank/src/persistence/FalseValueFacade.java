package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class FalseValueFacade{

	private String schemaName;
	private Connection con;

	public FalseValueFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public FalseValueProxi getTheFalseValue() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FlsVlFacade.getTheFlsVl; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (FalseValueProxi)PersistentProxi.createProxi(id, 166);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FalseValue getFalseValue(long FalseValueId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FlsVlFacade.getFlsVl(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, FalseValueId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentBooleanValue This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10103: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10104: {
                        This = (PersistentBooleanValue)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            FalseValue result = new FalseValue(subService, 
                                               This, 
                                               FalseValueId);
            links.close();
            callable.close();
            FalseValueICProxi inCache = (FalseValueICProxi)Cache.getTheCache().put(result);
            FalseValue objectInCache = (FalseValue)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

