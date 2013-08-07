package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class TransferFacade{

	private String schemaName;
	private Connection con;

	public TransferFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public TransferProxi newTransfer(java.sql.Timestamp timestamp,long receiverAccountNumber,long receiverBankNumber,String subject,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newTrnsfr(?,?,?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setTimestamp(2, timestamp);
            callable.setLong(3, receiverAccountNumber);
            callable.setLong(4, receiverBankNumber);
            callable.setString(5, subject);
            callable.setLong(6, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(timestamp,null,null,receiverAccountNumber,receiverBankNumber,null,null,subject,null,null,id);
            Cache.getTheCache().put(result);
            return (TransferProxi)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TransferProxi newDelayedTransfer(java.sql.Timestamp timestamp,long receiverAccountNumber,long receiverBankNumber,String subject) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newDelayedTrnsfr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(timestamp,null,null,receiverAccountNumber,receiverBankNumber,null,null,subject,null,null,id);
            Cache.getTheCache().put(result);
            return (TransferProxi)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Transfer getTransfer(long TransferId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.getTrnsfr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, TransferId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(3) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentDebitNoteTransferTransaction This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentDebitNoteTransferTransaction)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentAccount sender = null;
            if (obj.getLong(9) != 0)
                sender = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentMoney money = null;
            if (obj.getLong(11) != 0)
                money = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            PersistentDebitNoteTransferState state = null;
            if (obj.getLong(14) != 0)
                state = (PersistentDebitNoteTransferState)PersistentProxi.createProxi(obj.getLong(14), obj.getLong(15));
            PersistentStornoState stornoState = null;
            if (obj.getLong(16) != 0)
                stornoState = (PersistentStornoState)PersistentProxi.createProxi(obj.getLong(16), obj.getLong(17));
            Transfer result = new Transfer(obj.getTimestamp(2),
                                           subService,
                                           This,
                                           obj.getLong(7),
                                           obj.getLong(8),
                                           sender,
                                           money,
                                           obj.getString(13) == null ? "" : obj.getString(13) /* In Oracle "" = null !!! */,
                                           state,
                                           stornoState,
                                           TransferId);
            obj.close();
            callable.close();
            TransferICProxi inCache = (TransferICProxi)Cache.getTheCache().put(result);
            Transfer objectInCache = (Transfer)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

