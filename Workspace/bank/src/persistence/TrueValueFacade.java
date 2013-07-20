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
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentBooleanValue This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentBooleanValue)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            TrueValue result = new TrueValue(subService,
                                             This,
                                             TrueValueId);
            obj.close();
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

