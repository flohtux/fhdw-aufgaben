package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MateriallistFacade{

	private String schemaName;
	private Connection con;

	public MateriallistFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MateriallistProxi newMateriallist(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrllstFacade.newMtrllst(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Materiallist result = new Materiallist(null,id);
            Cache.getTheCache().put(result);
            return (MateriallistProxi)PersistentProxi.createProxi(id, 111);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MateriallistProxi newDelayedMateriallist() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrllstFacade.newDelayedMtrllst(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Materiallist result = new Materiallist(null,id);
            Cache.getTheCache().put(result);
            return (MateriallistProxi)PersistentProxi.createProxi(id, 111);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Materiallist getMateriallist(long MateriallistId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrllstFacade.getMtrllst(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MateriallistId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMateriallist This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentMateriallist)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Materiallist result = new Materiallist(This,
                                                   MateriallistId);
            obj.close();
            callable.close();
            MateriallistICProxi inCache = (MateriallistICProxi)Cache.getTheCache().put(result);
            Materiallist objectInCache = (Materiallist)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrllstFacade.getClass(?); end;");
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
    public long valuesAdd(long MateriallistId, PersistentMateriallistValue valuesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrllstFacade.vlsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, MateriallistId);
            callable.setLong(3, valuesVal.getId());
            callable.setLong(4, valuesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void valuesRem(long valuesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtrllstFacade.vlsRem(?); end;");
            callable.setLong(1, valuesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MateriallistValueList valuesGet(long MateriallistId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MtrllstFacade.vlsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MateriallistId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MateriallistValueList result = new MateriallistValueList();
            while (list.next()) {
                result.add((PersistentMateriallistValue)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long MateriallistId, PersistentMateriallist ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MtrllstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MateriallistId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

