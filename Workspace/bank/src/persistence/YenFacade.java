package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class YenFacade{

	private String schemaName;
	private Connection con;

	public YenFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public YenProxi getTheYen() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".YnFacade.getTheYn; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (YenProxi)PersistentProxi.createProxi(id, 181);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Yen getYen(long YenId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".YnFacade.getYn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, YenId);
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
            Yen result = new Yen(subService,
                                 This,
                                 YenId);
            obj.close();
            callable.close();
            YenICProxi inCache = (YenICProxi)Cache.getTheCache().put(result);
            Yen objectInCache = (Yen)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

