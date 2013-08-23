package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class PfundFacade{

	private String schemaName;
	private Connection con;

	public PfundFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PfundProxi getThePfund() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PfndFacade.getThePfnd; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PfundProxi)PersistentProxi.createProxi(id, 182);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Pfund getPfund(long PfundId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PfndFacade.getPfnd(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, PfundId);
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
            Pfund result = new Pfund(subService,
                                     This,
                                     PfundId);
            obj.close();
            callable.close();
            PfundICProxi inCache = (PfundICProxi)Cache.getTheCache().put(result);
            Pfund objectInCache = (Pfund)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

