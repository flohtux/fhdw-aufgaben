package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AdministratorBanksFacade{

	private String schemaName;
	private Connection con;

	public AdministratorBanksFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AdministratorBanksProxi newAdministratorBanks(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrBnksFacade.newAdmnstrtrBnks(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AdministratorBanks result = new AdministratorBanks(null,null,id);
            Cache.getTheCache().put(result);
            return (AdministratorBanksProxi)PersistentProxi.createProxi(id, 131);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AdministratorBanksProxi newDelayedAdministratorBanks() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrBnksFacade.newDelayedAdmnstrtrBnks(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AdministratorBanks result = new AdministratorBanks(null,null,id);
            Cache.getTheCache().put(result);
            return (AdministratorBanksProxi)PersistentProxi.createProxi(id, 131);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AdministratorBanks getAdministratorBanks(long AdministratorBanksId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrBnksFacade.getAdmnstrtrBnks(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AdministratorBanksId);
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
            PersistentAdministratorBanks This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentAdministratorBanks)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            AdministratorBanks result = new AdministratorBanks(observer,
                                                               This,
                                                               AdministratorBanksId);
            obj.close();
            callable.close();
            AdministratorBanksICProxi inCache = (AdministratorBanksICProxi)Cache.getTheCache().put(result);
            AdministratorBanks objectInCache = (AdministratorBanks)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrBnksFacade.getClass(?); end;");
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
    public void observerSet(long AdministratorBanksId, PersistentAdministrator observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnstrtrBnksFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AdministratorBanksId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long observeeAdd(long AdministratorBanksId, PersistentBank observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrBnksFacade.obsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AdministratorBanksId);
            callable.setLong(3, observeeVal.getId());
            callable.setLong(4, observeeVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeRem(long observeeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnstrtrBnksFacade.obsRem(?); end;");
            callable.setLong(1, observeeId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public BankList observeeGet(long AdministratorBanksId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrBnksFacade.obsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AdministratorBanksId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            BankList result = new BankList();
            while (list.next()) {
                result.add((PersistentBank)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AdministratorBanksId, PersistentAdministratorBanks ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnstrtrBnksFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AdministratorBanksId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

