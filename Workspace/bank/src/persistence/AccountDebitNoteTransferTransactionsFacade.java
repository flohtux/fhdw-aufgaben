package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountDebitNoteTransferTransactionsFacade{

	private String schemaName;
	private Connection con;

	public AccountDebitNoteTransferTransactionsFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountDebitNoteTransferTransactionsProxi newAccountDebitNoteTransferTransactions(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.newAccntDebTrfTrans(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountDebitNoteTransferTransactions result = new AccountDebitNoteTransferTransactions(null,null,id);
            Cache.getTheCache().put(result);
            return (AccountDebitNoteTransferTransactionsProxi)PersistentProxi.createProxi(id, 172);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountDebitNoteTransferTransactionsProxi newDelayedAccountDebitNoteTransferTransactions() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.newDelayedAccntDebTrfTrans(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountDebitNoteTransferTransactions result = new AccountDebitNoteTransferTransactions(null,null,id);
            Cache.getTheCache().put(result);
            return (AccountDebitNoteTransferTransactionsProxi)PersistentProxi.createProxi(id, 172);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountDebitNoteTransferTransactions getAccountDebitNoteTransferTransactions(long AccountDebitNoteTransferTransactionsId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.getAccntDebTrfTrans(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountDebitNoteTransferTransactionsId);
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
            PersistentAccountDebitNoteTransferTransactions This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentAccountDebitNoteTransferTransactions)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            AccountDebitNoteTransferTransactions result = new AccountDebitNoteTransferTransactions(observer,
                                                                                                   This,
                                                                                                   AccountDebitNoteTransferTransactionsId);
            obj.close();
            callable.close();
            AccountDebitNoteTransferTransactionsICProxi inCache = (AccountDebitNoteTransferTransactionsICProxi)Cache.getTheCache().put(result);
            AccountDebitNoteTransferTransactions objectInCache = (AccountDebitNoteTransferTransactions)inCache.getTheObject();
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
    public void observerSet(long AccountDebitNoteTransferTransactionsId, PersistentAccount observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntDebTrfTransFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountDebitNoteTransferTransactionsId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long observeeAdd(long AccountDebitNoteTransferTransactionsId, PersistentDebitNoteTransferTransaction observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.obsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AccountDebitNoteTransferTransactionsId);
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
    public DebitNoteTransferTransactionList observeeGet(long AccountDebitNoteTransferTransactionsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntDebTrfTransFacade.obsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountDebitNoteTransferTransactionsId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitNoteTransferTransactionList result = new DebitNoteTransferTransactionList();
            while (list.next()) {
                result.add((PersistentDebitNoteTransferTransaction)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountDebitNoteTransferTransactionsId, PersistentAccountDebitNoteTransferTransactions ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntDebTrfTransFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountDebitNoteTransferTransactionsId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

