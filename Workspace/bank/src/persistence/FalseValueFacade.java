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
            FalseValue result = new FalseValue(subService,
                                               This,
                                               FalseValueId);
            obj.close();
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

