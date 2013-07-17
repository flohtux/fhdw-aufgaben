package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MateriallistValueFacade{

	private String schemaName;
	private Connection con;

	public MateriallistValueFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MateriallistValueProxi newMateriallistValue(long amount,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrllstVlFacade.newMtrllstVl(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, amount);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MateriallistValue result = new MateriallistValue(null,amount,null,id);
            Cache.getTheCache().put(result);
            return (MateriallistValueProxi)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MateriallistValueProxi newDelayedMateriallistValue(long amount) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrllstVlFacade.newDelayedMtrllstVl(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MateriallistValue result = new MateriallistValue(null,amount,null,id);
            Cache.getTheCache().put(result);
            return (MateriallistValueProxi)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MateriallistValue getMateriallistValue(long MateriallistValueId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrllstVlFacade.getMtrllstVl(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MateriallistValueId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMaterial material = null;
            if (obj.getLong(2) != 0)
                material = (PersistentMaterial)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMateriallistValue This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentMateriallistValue)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            MateriallistValue result = new MateriallistValue(material,
                                                             obj.getLong(4),
                                                             This,
                                                             MateriallistValueId);
            obj.close();
            callable.close();
            MateriallistValueICProxi inCache = (MateriallistValueICProxi)Cache.getTheCache().put(result);
            MateriallistValue objectInCache = (MateriallistValue)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrllstVlFacade.getClass(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void materialSet(long MateriallistValueId, PersistentMaterial materialVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtrllstVlFacade.mtrlSet(?, ?, ?); end;");
            callable.setLong(1, MateriallistValueId);
            callable.setLong(2, materialVal.getId());
            callable.setLong(3, materialVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void amountSet(long MateriallistValueId, long amountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtrllstVlFacade.amntSet(?, ?); end;");
            callable.setLong(1, MateriallistValueId);
            callable.setLong(2, amountVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long MateriallistValueId, PersistentMateriallistValue ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtrllstVlFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MateriallistValueId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

