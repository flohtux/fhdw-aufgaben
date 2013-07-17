package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CachedFacade{

	private String schemaName;
	private Connection con;

	public CachedFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CachedProxi newCached(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CchdFacade.newCchd(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Cached result = new Cached(null,null,id);
            Cache.getTheCache().put(result);
            return (CachedProxi)PersistentProxi.createProxi(id, 107);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CachedProxi newDelayedCached() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CchdFacade.newDelayedCchd(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Cached result = new Cached(null,null,id);
            Cache.getTheCache().put(result);
            return (CachedProxi)PersistentProxi.createProxi(id, 107);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Cached getCached(long CachedId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CchdFacade.getCchd(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CachedId);
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
            PersistentMateriallist cachedList = null;
            if (obj.getLong(4) != 0)
                cachedList = (PersistentMateriallist)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Cached result = new Cached(This,
                                       cachedList,
                                       CachedId);
            obj.close();
            callable.close();
            CachedICProxi inCache = (CachedICProxi)Cache.getTheCache().put(result);
            Cached objectInCache = (Cached)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void cachedListSet(long CachedId, PersistentMateriallist cachedListVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CchdFacade.cchdLstSet(?, ?, ?); end;");
            callable.setLong(1, CachedId);
            callable.setLong(2, cachedListVal.getId());
            callable.setLong(3, cachedListVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

