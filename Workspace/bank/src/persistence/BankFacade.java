package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class BankFacade{

	private String schemaName;
	private Connection con;

	public BankFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public BankProxi newBank(long bankNumber,String name,long lastAccountNumber,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.newBnk(?,?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, bankNumber);
            callable.setString(3, name);
            callable.setLong(4, lastAccountNumber);
            callable.setLong(5, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Bank result = new Bank(bankNumber,name,lastAccountNumber,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (BankProxi)PersistentProxi.createProxi(id, -149);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BankProxi newDelayedBank(long bankNumber,String name,long lastAccountNumber) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.newDelayedBnk(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Bank result = new Bank(bankNumber,name,lastAccountNumber,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (BankProxi)PersistentProxi.createProxi(id, -149);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Bank getBank(long BankId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.getBnk(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, BankId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentBankFees bankFees = null;
            if (obj.getLong(5) != 0)
                bankFees = (PersistentBankFees)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentBankOwnAccountPx ownAccount = null;
            if (obj.getLong(7) != 0)
                ownAccount = (PersistentBankOwnAccountPx)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentAdministrator administrator = null;
            if (obj.getLong(9) != 0)
                administrator = (PersistentAdministrator)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            SubjInterface subService = null;
            if (obj.getLong(11) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            PersistentBank This = null;
            if (obj.getLong(13) != 0)
                This = (PersistentBank)PersistentProxi.createProxi(obj.getLong(13), obj.getLong(14));
            Bank result = new Bank(obj.getLong(2),
                                   obj.getString(3) == null ? "" : obj.getString(3) /* In Oracle "" = null !!! */,
                                   obj.getLong(4),
                                   bankFees,
                                   ownAccount,
                                   administrator,
                                   subService,
                                   This,
                                   BankId);
            obj.close();
            callable.close();
            BankICProxi inCache = (BankICProxi)Cache.getTheCache().put(result);
            Bank objectInCache = (Bank)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.getClass(?); end;");
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
    public BankSearchList getBankByBankNumber(long bankNumber) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.getBnkByBnkNmbr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, bankNumber);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            BankSearchList result = new BankSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                BankProxi proxi = (BankProxi)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public BankSearchList getBankByName(String name) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.getBnkByNm(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setString(2, name);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            BankSearchList result = new BankSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                BankProxi proxi = (BankProxi)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void bankNumberSet(long BankId, long bankNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.bnkNmbrSet(?, ?); end;");
            callable.setLong(1, BankId);
            callable.setLong(2, bankNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long BankId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.nmSet(?, ?); end;");
            callable.setLong(1, BankId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void lastAccountNumberSet(long BankId, long lastAccountNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.lstAccNoSet(?, ?); end;");
            callable.setLong(1, BankId);
            callable.setLong(2, lastAccountNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void bankFeesSet(long BankId, PersistentBankFees bankFeesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.bnkFsSet(?, ?, ?); end;");
            callable.setLong(1, BankId);
            callable.setLong(2, bankFeesVal.getId());
            callable.setLong(3, bankFeesVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ownAccountSet(long BankId, PersistentBankOwnAccountPx ownAccountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.ownAccntSet(?, ?, ?); end;");
            callable.setLong(1, BankId);
            callable.setLong(2, ownAccountVal.getId());
            callable.setLong(3, ownAccountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long accountsAdd(long BankId, long indxxVal, PersistentAccount accountsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.accntsAdd(?, ?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, BankId);
            callable.setLong(3, indxxVal);
            callable.setLong(4, accountsVal.getId());
            callable.setLong(5, accountsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void accountsRem(long BankId, long indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.accntsRem(?,?); end;");
            callable.setLong(1, BankId);
            callable.setLong(2, indxxVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentAccount accountsGet(long BankId, long indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.accntsGet(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, BankId);
            callable.setLong(3, indxxVal);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccount result = null;
            if (list.next()) result = (PersistentAccount)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AccountSearchList accountsGetValues(long BankId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.accntsGetValues(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, BankId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AccountSearchList result = new AccountSearchList();
            while (list.next()) {
                result.add((PersistentAccount)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void administratorSet(long BankId, PersistentAdministrator administratorVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.admnstrtrSet(?, ?, ?); end;");
            callable.setLong(1, BankId);
            callable.setLong(2, administratorVal.getId());
            callable.setLong(3, administratorVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long BankId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, BankId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long BankId, PersistentBank ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, BankId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public BankSearchList inverseGetAccounts(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.iGetAccnts(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            BankSearchList result = new BankSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentBank)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentBank)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public BankSearchList inverseGetAdministrator(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFacade.iGetAdmnstrtr(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            BankSearchList result = new BankSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentBank)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentBank)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

