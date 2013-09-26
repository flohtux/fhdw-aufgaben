package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DebitGrantListePxFacade{

	private String schemaName;
	private Connection con;

	public DebitGrantListePxFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DebitGrantListePxProxi newDebitGrantListePx(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DGrantPxFacade.newDGrantPx(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitGrantListePx result = new DebitGrantListePx(null,null,null,id);
            Cache.getTheCache().put(result);
            return (DebitGrantListePxProxi)PersistentProxi.createProxi(id, 286);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitGrantListePxProxi newDelayedDebitGrantListePx() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DGrantPxFacade.newDelayedDGrantPx(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitGrantListePx result = new DebitGrantListePx(null,null,null,id);
            Cache.getTheCache().put(result);
            return (DebitGrantListePxProxi)PersistentProxi.createProxi(id, 286);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitGrantListePx getDebitGrantListePx(long DebitGrantListePxId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DGrantPxFacade.getDGrantPx(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitGrantListePxId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentDebitGrantListe d1 = null;
            if (obj.getLong(2) != 0)
                d1 = (PersistentDebitGrantListe)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            SubjInterface subService = null;
            if (obj.getLong(4) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentDebitGrantListePx This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentDebitGrantListePx)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            DebitGrantListePx result = new DebitGrantListePx(d1,
                                                             subService,
                                                             This,
                                                             DebitGrantListePxId);
            obj.close();
            callable.close();
            DebitGrantListePxICProxi inCache = (DebitGrantListePxICProxi)Cache.getTheCache().put(result);
            DebitGrantListePx objectInCache = (DebitGrantListePx)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DGrantPxFacade.getClass(?); end;");
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
    public void d1Set(long DebitGrantListePxId, PersistentDebitGrantListe d1Val) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DGrantPxFacade.d1Set(?, ?, ?); end;");
            callable.setLong(1, DebitGrantListePxId);
            callable.setLong(2, d1Val.getId());
            callable.setLong(3, d1Val.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long DebitGrantListePxId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DGrantPxFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitGrantListePxId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitGrantListePxId, PersistentDebitGrantListePx ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DGrantPxFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitGrantListePxId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

