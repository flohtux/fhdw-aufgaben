package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class TransactionFacade{

	private String schemaName;
	private Connection con;

	public TransactionFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public TransactionProxi newTransaction(java.sql.Timestamp timestamp,String subject,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.newTrnsctn(?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setTimestamp(2, timestamp);
            callable.setString(3, subject);
            callable.setLong(4, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transaction result = new Transaction(timestamp,subject,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (TransactionProxi)PersistentProxi.createProxi(id, 146);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TransactionProxi newDelayedTransaction(java.sql.Timestamp timestamp,String subject) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.newDelayedTrnsctn(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transaction result = new Transaction(timestamp,subject,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (TransactionProxi)PersistentProxi.createProxi(id, 146);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Transaction getTransaction(long TransactionId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.getTrnsctn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, TransactionId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAccount sender = null;
            if (obj.getLong(4) != 0)
                sender = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentDebitTransferState state = null;
            if (obj.getLong(6) != 0)
                state = (PersistentDebitTransferState)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            SubjInterface subService = null;
            if (obj.getLong(8) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentDebitTransferTransaction This = null;
            if (obj.getLong(10) != 0)
                This = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            PersistentDebitTransferListe debitTransfer = null;
            if (obj.getLong(12) != 0)
                debitTransfer = (PersistentDebitTransferListe)PersistentProxi.createProxi(obj.getLong(12), obj.getLong(13));
            Transaction result = new Transaction(obj.getTimestamp(2),
                                                 obj.getString(3) == null ? "" : obj.getString(3) /* In Oracle "" = null !!! */,
                                                 sender,
                                                 state,
                                                 subService,
                                                 This,
                                                 debitTransfer,
                                                 TransactionId);
            obj.close();
            callable.close();
            TransactionICProxi inCache = (TransactionICProxi)Cache.getTheCache().put(result);
            Transaction objectInCache = (Transaction)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void debitTransferSet(long TransactionId, PersistentDebitTransferListe debitTransferVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsctnFacade.dbtTrnsfrSet(?, ?, ?); end;");
            callable.setLong(1, TransactionId);
            callable.setLong(2, debitTransferVal.getId());
            callable.setLong(3, debitTransferVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

