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
            Transfer result = new Transfer(timestamp,null,null,null,null,receiverAccountNumber,receiverBankNumber,null,subject,null,id);
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
            Transfer result = new Transfer(timestamp,null,null,null,null,receiverAccountNumber,receiverBankNumber,null,subject,null,id);
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
            PersistentAccount sender = null;
            if (obj.getLong(3) != 0)
                sender = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentDebitTransferState state = null;
            if (obj.getLong(5) != 0)
                state = (PersistentDebitTransferState)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            SubjInterface subService = null;
            if (obj.getLong(7) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentDebitTransferTransaction This = null;
            if (obj.getLong(9) != 0)
                This = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentMoney money = null;
            if (obj.getLong(13) != 0)
                money = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(13), obj.getLong(14));
            PersistentStornoState stornoState = null;
            if (obj.getLong(16) != 0)
                stornoState = (PersistentStornoState)PersistentProxi.createProxi(obj.getLong(16), obj.getLong(17));
            Transfer result = new Transfer(obj.getTimestamp(2),
                                           sender,
                                           state,
                                           subService,
                                           This,
                                           obj.getLong(11),
                                           obj.getLong(12),
                                           money,
                                           obj.getString(15) == null ? "" : obj.getString(15) /* In Oracle "" = null !!! */,
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

