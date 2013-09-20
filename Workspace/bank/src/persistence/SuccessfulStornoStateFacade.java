package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class SuccessfulStornoStateFacade{

	private String schemaName;
	private Connection con;

	public SuccessfulStornoStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public SuccessfulStornoStateProxi getTheSuccessfulStornoState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SucStoStaFacade.getTheSucStoSta; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (SuccessfulStornoStateProxi)PersistentProxi.createProxi(id, 123);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SuccessfulStornoState getSuccessfulStornoState(long SuccessfulStornoStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SucStoStaFacade.getSucStoSta(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, SuccessfulStornoStateId);
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
            PersistentStornoState This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentStornoState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SuccessfulStornoState result = new SuccessfulStornoState(subService,
                                                                     This,
                                                                     SuccessfulStornoStateId);
            obj.close();
            callable.close();
            SuccessfulStornoStateICProxi inCache = (SuccessfulStornoStateICProxi)Cache.getTheCache().put(result);
            SuccessfulStornoState objectInCache = (SuccessfulStornoState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

