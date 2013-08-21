package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountFacade{

	private String schemaName;
	private Connection con;

	public AccountFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountProxi newAccount(long accountNumber,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.newAccnt(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, accountNumber);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Account result = new Account(accountNumber,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountProxi)PersistentProxi.createProxi(id, 133);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountProxi newDelayedAccount(long accountNumber) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.newDelayedAccnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Account result = new Account(accountNumber,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountProxi)PersistentProxi.createProxi(id, 133);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Account getAccount(long AccountId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.getAccnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMoney money = null;
            if (obj.getLong(3) != 0)
                money = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentLimitAccount limit = null;
            if (obj.getLong(5) != 0)
                limit = (PersistentLimitAccount)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentAccountDebitTransferTransactions debitTransferTransactions = null;
            if (obj.getLong(7) != 0)
                debitTransferTransactions = (PersistentAccountDebitTransferTransactions)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            SubjInterface subService = null;
            if (obj.getLong(9) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentAccount This = null;
            if (obj.getLong(11) != 0)
                This = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            Account result = new Account(obj.getLong(2),
                                         money,
                                         limit,
                                         debitTransferTransactions,
                                         subService,
                                         This,
                                         AccountId);
            obj.close();
            callable.close();
            AccountICProxi inCache = (AccountICProxi)Cache.getTheCache().put(result);
            Account objectInCache = (Account)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.getClass(?); end;");
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
    public AccountSearchList getAccountByAccountNumber(long accountNumber) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.getAccntByAccntNmbr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, accountNumber);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AccountSearchList result = new AccountSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                AccountProxi proxi = (AccountProxi)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void accountNumberSet(long AccountId, long accountNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.accntNmbrSet(?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setLong(2, accountNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moneySet(long AccountId, PersistentMoney moneyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.mnSet(?, ?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setLong(2, moneyVal.getId());
            callable.setLong(3, moneyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void limitSet(long AccountId, PersistentLimitAccount limitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.lmtSet(?, ?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setLong(2, limitVal.getId());
            callable.setLong(3, limitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void debitTransferTransactionsSet(long AccountId, PersistentAccountDebitTransferTransactions debitTransferTransactionsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.DebTrfTransSet(?, ?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setLong(2, debitTransferTransactionsVal.getId());
            callable.setLong(3, debitTransferTransactionsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long grantedDebitGrantsAdd(long AccountId, PersistentDebitGrant grantedDebitGrantsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.GrntdGrntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AccountId);
            callable.setLong(3, grantedDebitGrantsVal.getId());
            callable.setLong(4, grantedDebitGrantsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void grantedDebitGrantsRem(long grantedDebitGrantsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.GrntdGrntsRem(?); end;");
            callable.setLong(1, grantedDebitGrantsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitGrantList grantedDebitGrantsGet(long AccountId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.GrntdGrntsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitGrantList result = new DebitGrantList();
            while (list.next()) {
                result.add((PersistentDebitGrant)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long receivedDebitGrantsAdd(long AccountId, PersistentDebitGrant receivedDebitGrantsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.RcvdGrntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AccountId);
            callable.setLong(3, receivedDebitGrantsVal.getId());
            callable.setLong(4, receivedDebitGrantsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void receivedDebitGrantsRem(long receivedDebitGrantsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.RcvdGrntsRem(?); end;");
            callable.setLong(1, receivedDebitGrantsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitGrantList receivedDebitGrantsGet(long AccountId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.RcvdGrntsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitGrantList result = new DebitGrantList();
            while (list.next()) {
                result.add((PersistentDebitGrant)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long AccountId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountId, PersistentAccount ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AccountSearchList inverseGetMoney(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.iGetMn(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AccountSearchList result = new AccountSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentAccount)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentAccount)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AccountSearchList inverseGetLimit(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntFacade.iGetLmt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AccountSearchList result = new AccountSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentAccount)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentAccount)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

