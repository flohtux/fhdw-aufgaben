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
            Bank result = new Bank(bankNumber,name,lastAccountNumber,null,null,null,null,null,null,id);
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
            Bank result = new Bank(bankNumber,name,lastAccountNumber,null,null,null,null,null,null,id);
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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            long bankNumber = 0;
            String name = "";
            long lastAccountNumber = 0;
            PersistentTransactionFee fee = null;
            PersistentInternalFee internalFee = null;
            PersistentAccount ownAccount = null;
            PersistentAdministrator administrator = null;
            SubjInterface subService = null;
            PersistentBank This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10082: {
                        bankNumber = links.getLong(5);
                        break;
                    }
                    case 10083: {
                        name = links.getString(6);
                        if(name == null)name = "";
                        break;
                    }
                    case 10084: {
                        lastAccountNumber = links.getLong(5);
                        break;
                    }
                    case 10085: {
                        fee = (PersistentTransactionFee)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10086: {
                        internalFee = (PersistentInternalFee)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10087: {
                        ownAccount = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10105: {
                        administrator = (PersistentAdministrator)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10090: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10091: {
                        This = (PersistentBank)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            Bank result = new Bank(bankNumber, 
                                   name, 
                                   lastAccountNumber, 
                                   fee, 
                                   internalFee, 
                                   ownAccount, 
                                   administrator, 
                                   subService, 
                                   This, 
                                   BankId);
            links.close();
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
    public void feeSet(long BankId, PersistentTransactionFee feeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.feeSet(?, ?, ?); end;");
            callable.setLong(1, BankId);
            callable.setLong(2, feeVal.getId());
            callable.setLong(3, feeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void internalFeeSet(long BankId, PersistentInternalFee internalFeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFacade.intrnlFSet(?, ?, ?); end;");
            callable.setLong(1, BankId);
            callable.setLong(2, internalFeeVal.getId());
            callable.setLong(3, internalFeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ownAccountSet(long BankId, PersistentAccount ownAccountVal) throws PersistenceException {
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

