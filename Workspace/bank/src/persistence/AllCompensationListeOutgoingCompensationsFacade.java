package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AllCompensationListeOutgoingCompensationsFacade{

	private String schemaName;
	private Connection con;

	public AllCompensationListeOutgoingCompensationsFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AllCompensationListeOutgoingCompensationsProxi newAllCompensationListeOutgoingCompensations(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstOutgngCmpsFacade.newAllCmpLstOutgngCmps(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AllCompensationListeOutgoingCompensations result = new AllCompensationListeOutgoingCompensations(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AllCompensationListeOutgoingCompensationsProxi)PersistentProxi.createProxi(id, 269);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AllCompensationListeOutgoingCompensationsProxi newDelayedAllCompensationListeOutgoingCompensations() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstOutgngCmpsFacade.newDelayedAllCmpLstOutgngCmps(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AllCompensationListeOutgoingCompensations result = new AllCompensationListeOutgoingCompensations(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AllCompensationListeOutgoingCompensationsProxi)PersistentProxi.createProxi(id, 269);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AllCompensationListeOutgoingCompensations getAllCompensationListeOutgoingCompensations(long AllCompensationListeOutgoingCompensationsId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstOutgngCmpsFacade.getAllCmpLstOutgngCmps(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AllCompensationListeOutgoingCompensationsId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAllCompensationListe observer = null;
            if (obj.getLong(2) != 0)
                observer = (PersistentAllCompensationListe)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentCompensationListe observee = null;
            if (obj.getLong(4) != 0)
                observee = (PersistentCompensationListe)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAllCompensationListeOutgoingCompensations This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentAllCompensationListeOutgoingCompensations)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            AllCompensationListeOutgoingCompensations result = new AllCompensationListeOutgoingCompensations(observer,
                                                                                                             observee,
                                                                                                             This,
                                                                                                             AllCompensationListeOutgoingCompensationsId);
            obj.close();
            callable.close();
            AllCompensationListeOutgoingCompensationsICProxi inCache = (AllCompensationListeOutgoingCompensationsICProxi)Cache.getTheCache().put(result);
            AllCompensationListeOutgoingCompensations objectInCache = (AllCompensationListeOutgoingCompensations)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstOutgngCmpsFacade.getClass(?); end;");
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
    public void observerSet(long AllCompensationListeOutgoingCompensationsId, PersistentAllCompensationListe observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AllCmpLstOutgngCmpsFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AllCompensationListeOutgoingCompensationsId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AllCompensationListeOutgoingCompensationsId, PersistentCompensationListe observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AllCmpLstOutgngCmpsFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AllCompensationListeOutgoingCompensationsId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AllCompensationListeOutgoingCompensationsId, PersistentAllCompensationListeOutgoingCompensations ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AllCmpLstOutgngCmpsFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AllCompensationListeOutgoingCompensationsId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

