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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentCurrency This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10025: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10026: {
                        This = (PersistentCurrency)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            Euro result = new Euro(subService, 
                                   This, 
                                   EuroId);
            links.close();
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

