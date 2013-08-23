package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AdministratorCurrencyManagerFacade{

	private String schemaName;
	private Connection con;

	public AdministratorCurrencyManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AdministratorCurrencyManagerProxi newAdministratorCurrencyManager(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrCrrncMngrFacade.newAdmnstrtrCrrncMngr(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AdministratorCurrencyManager result = new AdministratorCurrencyManager(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AdministratorCurrencyManagerProxi)PersistentProxi.createProxi(id, 183);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AdministratorCurrencyManagerProxi newDelayedAdministratorCurrencyManager() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrCrrncMngrFacade.newDelayedAdmnstrtrCrrncMngr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AdministratorCurrencyManager result = new AdministratorCurrencyManager(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AdministratorCurrencyManagerProxi)PersistentProxi.createProxi(id, 183);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AdministratorCurrencyManager getAdministratorCurrencyManager(long AdministratorCurrencyManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrCrrncMngrFacade.getAdmnstrtrCrrncMngr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AdministratorCurrencyManagerId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAdministrator observer = null;
            if (obj.getLong(2) != 0)
                observer = (PersistentAdministrator)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentCurrencyManager observee = null;
            if (obj.getLong(4) != 0)
                observee = (PersistentCurrencyManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAdministratorCurrencyManager This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentAdministratorCurrencyManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            AdministratorCurrencyManager result = new AdministratorCurrencyManager(observer,
                                                                                   observee,
                                                                                   This,
                                                                                   AdministratorCurrencyManagerId);
            obj.close();
            callable.close();
            AdministratorCurrencyManagerICProxi inCache = (AdministratorCurrencyManagerICProxi)Cache.getTheCache().put(result);
            AdministratorCurrencyManager objectInCache = (AdministratorCurrencyManager)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrCrrncMngrFacade.getClass(?); end;");
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
    public void observerSet(long AdministratorCurrencyManagerId, PersistentAdministrator observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnstrtrCrrncMngrFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AdministratorCurrencyManagerId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AdministratorCurrencyManagerId, PersistentCurrencyManager observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnstrtrCrrncMngrFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AdministratorCurrencyManagerId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AdministratorCurrencyManagerId, PersistentAdministratorCurrencyManager ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnstrtrCrrncMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AdministratorCurrencyManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

