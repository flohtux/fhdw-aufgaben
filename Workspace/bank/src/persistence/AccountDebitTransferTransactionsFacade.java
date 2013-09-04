package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountDebitTransferTransactionsFacade{

	private String schemaName;
	private Connection con;

	public AccountDebitTransferTransactionsFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountDebitTransferTransactionsProxi newAccountDebitTransferTransactions(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.newAccntDebTrfTrans(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountDebitTransferTransactions result = new AccountDebitTransferTransactions(null,null,id);
            Cache.getTheCache().put(result);
            return (AccountDebitTransferTransactionsProxi)PersistentProxi.createProxi(id, 226);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountDebitTransferTransactionsProxi newDelayedAccountDebitTransferTransactions() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.newDelayedAccntDebTrfTrans(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountDebitTransferTransactions result = new AccountDebitTransferTransactions(null,null,id);
            Cache.getTheCache().put(result);
            return (AccountDebitTransferTransactionsProxi)PersistentProxi.createProxi(id, 226);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountDebitTransferTransactions getAccountDebitTransferTransactions(long AccountDebitTransferTransactionsId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.getAccntDebTrfTrans(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountDebitTransferTransactionsId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAccount observer = null;
            if (obj.getLong(2) != 0)
                observer = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAccountDebitTransferTransactions This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentAccountDebitTransferTransactions)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            AccountDebitTransferTransactions result = new AccountDebitTransferTransactions(observer,
                                                                                           This,
                                                                                           AccountDebitTransferTransactionsId);
            obj.close();
            callable.close();
            AccountDebitTransferTransactionsICProxi inCache = (AccountDebitTransferTransactionsICProxi)Cache.getTheCache().put(result);
            AccountDebitTransferTransactions objectInCache = (AccountDebitTransferTransactions)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.getClass(?); end;");
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
    public void observerSet(long AccountDebitTransferTransactionsId, PersistentAccount observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntDebTrfTransFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountDebitTransferTransactionsId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long observeeAdd(long AccountDebitTransferTransactionsId, PersistentDebitTransferTransaction observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.obsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AccountDebitTransferTransactionsId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntDebTrfTransFacade.obsRem(?); end;");
            callable.setLong(1, observeeId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferTransactionList observeeGet(long AccountDebitTransferTransactionsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.obsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountDebitTransferTransactionsId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitTransferTransactionList result = new DebitTransferTransactionList();
            while (list.next()) {
                result.add((PersistentDebitTransferTransaction)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountDebitTransferTransactionsId, PersistentAccountDebitTransferTransactions ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntDebTrfTransFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountDebitTransferTransactionsId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

