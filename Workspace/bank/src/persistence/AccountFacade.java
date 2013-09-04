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
            Account result = new Account(accountNumber,null,null,null,null,null,null,null,id);
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
            Account result = new Account(accountNumber,null,null,null,null,null,null,null,id);
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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            long accountNumber = 0;
            PersistentMoney money = null;
            PersistentLimitAccount limit = null;
            PersistentAccountDebitTransferTransactions debitTransferTransactions = null;
            PersistentAccountGrantedDebitGrant grantedDebitGrant = null;
            PersistentAccountReceivedDebitGrant receivedDebitGrant = null;
            SubjInterface subService = null;
            PersistentAccount This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10061: {
                        accountNumber = links.getLong(5);
                        break;
                    }
                    case 10062: {
                        money = (PersistentMoney)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10063: {
                        limit = (PersistentLimitAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10109: {
                        debitTransferTransactions = (PersistentAccountDebitTransferTransactions)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10213: {
                        grantedDebitGrant = (PersistentAccountGrantedDebitGrant)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10208: {
                        receivedDebitGrant = (PersistentAccountReceivedDebitGrant)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10064: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10065: {
                        This = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            Account result = new Account(accountNumber, 
                                         money, 
                                         limit, 
                                         debitTransferTransactions, 
                                         grantedDebitGrant, 
                                         receivedDebitGrant, 
                                         subService, 
                                         This, 
                                         AccountId);
            links.close();
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
    public void grantedDebitGrantSet(long AccountId, PersistentAccountGrantedDebitGrant grantedDebitGrantVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.GrntdGrntSet(?, ?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setLong(2, grantedDebitGrantVal.getId());
            callable.setLong(3, grantedDebitGrantVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void receivedDebitGrantSet(long AccountId, PersistentAccountReceivedDebitGrant receivedDebitGrantVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntFacade.RcvdGrntSet(?, ?, ?); end;");
            callable.setLong(1, AccountId);
            callable.setLong(2, receivedDebitGrantVal.getId());
            callable.setLong(3, receivedDebitGrantVal.getClassId());
            callable.execute();
            callable.close();
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

