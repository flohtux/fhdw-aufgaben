package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class TrueValueFacade{

	private String schemaName;
	private Connection con;

	public TrueValueFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public TrueValueProxi getTheTrueValue() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrVlFacade.getTheTrVl; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (TrueValueProxi)PersistentProxi.createProxi(id, 168);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TrueValue getTrueValue(long TrueValueId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrVlFacade.getTrVl(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, TrueValueId);
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
            TrueValue result = new TrueValue(subService, 
                                             This, 
                                             TrueValueId);
            links.close();
            callable.close();
            TrueValueICProxi inCache = (TrueValueICProxi)Cache.getTheCache().put(result);
            TrueValue objectInCache = (TrueValue)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

