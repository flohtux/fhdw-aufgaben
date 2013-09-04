package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NoLimitFacade{

	private String schemaName;
	private Connection con;

	public NoLimitFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NoLimitProxi getTheNoLimit() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NLmtFacade.getTheNLmt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (NoLimitProxi)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoLimit getNoLimit(long NoLimitId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NLmtFacade.getNLmt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NoLimitId);
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
            PersistentLimitType This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentLimitType)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            NoLimit result = new NoLimit(subService,
                                         This,
                                         NoLimitId);
            obj.close();
            callable.close();
            NoLimitICProxi inCache = (NoLimitICProxi)Cache.getTheCache().put(result);
            NoLimit objectInCache = (NoLimit)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

