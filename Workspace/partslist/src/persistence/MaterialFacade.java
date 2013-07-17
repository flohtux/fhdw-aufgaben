package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MaterialFacade{

	private String schemaName;
	private Connection con;

	public MaterialFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MaterialProxi newMaterial(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrlFacade.newMtrl(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Material result = new Material(name,null,null,id);
            Cache.getTheCache().put(result);
            return (MaterialProxi)PersistentProxi.createProxi(id, 106);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MaterialProxi newDelayedMaterial(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrlFacade.newDelayedMtrl(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Material result = new Material(name,null,null,id);
            Cache.getTheCache().put(result);
            return (MaterialProxi)PersistentProxi.createProxi(id, 106);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Material getMaterial(long MaterialId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrlFacade.getMtrl(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MaterialId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentState currentState = null;
            if (obj.getLong(3) != 0)
                currentState = (PersistentState)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentComponent This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentComponent)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Material result = new Material(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                           currentState,
                                           This,
                                           MaterialId);
            obj.close();
            callable.close();
            MaterialICProxi inCache = (MaterialICProxi)Cache.getTheCache().put(result);
            Material objectInCache = (Material)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

