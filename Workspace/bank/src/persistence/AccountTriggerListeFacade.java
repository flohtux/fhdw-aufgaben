package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountTriggerListeFacade{

	private String schemaName;
	private Connection con;

	public AccountTriggerListeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountTriggerListeProxi newAccountTriggerListe(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntTrggrLstFacade.newAccntTrggrLst(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountTriggerListe result = new AccountTriggerListe(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountTriggerListeProxi)PersistentProxi.createProxi(id, 235);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountTriggerListeProxi newDelayedAccountTriggerListe() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntTrggrLstFacade.newDelayedAccntTrggrLst(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountTriggerListe result = new AccountTriggerListe(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountTriggerListeProxi)PersistentProxi.createProxi(id, 235);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountTriggerListe getAccountTriggerListe(long AccountTriggerListeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntTrggrLstFacade.getAccntTrggrLst(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountTriggerListeId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccount observer = null;
            PersistentTriggerListe observee = null;
            PersistentAccountTriggerListe This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10313: {
                        observer = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10314: {
                        observee = (PersistentTriggerListe)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10315: {
                        This = (PersistentAccountTriggerListe)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            AccountTriggerListe result = new AccountTriggerListe(observer, 
                                                                 observee, 
                                                                 This, 
                                                                 AccountTriggerListeId);
            links.close();
            callable.close();
            AccountTriggerListeICProxi inCache = (AccountTriggerListeICProxi)Cache.getTheCache().put(result);
            AccountTriggerListe objectInCache = (AccountTriggerListe)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntTrggrLstFacade.getClass(?); end;");
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
    public void observerSet(long AccountTriggerListeId, PersistentAccount observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntTrggrLstFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountTriggerListeId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AccountTriggerListeId, PersistentTriggerListe observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntTrggrLstFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AccountTriggerListeId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountTriggerListeId, PersistentAccountTriggerListe ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntTrggrLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountTriggerListeId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

