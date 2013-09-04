package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class EuroFacade{

	private String schemaName;
	private Connection con;

	public EuroFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public EuroProxi getTheEuro() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ErFacade.getTheEr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (EuroProxi)PersistentProxi.createProxi(id, 137);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Euro getEuro(long EuroId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ErFacade.getEr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, EuroId);
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
            PersistentCurrency This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentCurrency)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Euro result = new Euro(subService,
                                   This,
                                   EuroId);
            obj.close();
            callable.close();
            EuroICProxi inCache = (EuroICProxi)Cache.getTheCache().put(result);
            Euro objectInCache = (Euro)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

