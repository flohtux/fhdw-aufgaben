package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NotCachedFacade{

	private String schemaName;
	private Connection con;

	public NotCachedFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NotCachedProxi newNotCached(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NtCchdFacade.newNtCchd(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NotCached result = new NotCached(null,id);
            Cache.getTheCache().put(result);
            return (NotCachedProxi)PersistentProxi.createProxi(id, 113);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotCachedProxi newDelayedNotCached() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NtCchdFacade.newDelayedNtCchd(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NotCached result = new NotCached(null,id);
            Cache.getTheCache().put(result);
            return (NotCachedProxi)PersistentProxi.createProxi(id, 113);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotCached getNotCached(long NotCachedId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NtCchdFacade.getNtCchd(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NotCachedId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentState This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentState)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            NotCached result = new NotCached(This,
                                             NotCachedId);
            obj.close();
            callable.close();
            NotCachedICProxi inCache = (NotCachedICProxi)Cache.getTheCache().put(result);
            NotCached objectInCache = (NotCached)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

