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

    public TransferProxi newTransfer(long receiverAccountNumber,long receiverBankNumber,String subject,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newTrnsfr(?,?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, receiverAccountNumber);
            callable.setLong(3, receiverBankNumber);
            callable.setString(4, subject);
            callable.setLong(5, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(null,null,receiverAccountNumber,receiverBankNumber,null,null,subject,null,null,id);
            Cache.getTheCache().put(result);
            return (TransferProxi)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TransferProxi newDelayedTransfer(long receiverAccountNumber,long receiverBankNumber,String subject) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newDelayedTrnsfr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(null,null,receiverAccountNumber,receiverBankNumber,null,null,subject,null,null,id);
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
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentDebitNoteTransferTransaction This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentDebitNoteTransferTransaction)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAccount sender = null;
            if (obj.getLong(8) != 0)
                sender = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentMoney money = null;
            if (obj.getLong(10) != 0)
                money = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            PersistentDebitNoteTransferState state = null;
            if (obj.getLong(13) != 0)
                state = (PersistentDebitNoteTransferState)PersistentProxi.createProxi(obj.getLong(13), obj.getLong(14));
            PersistentStornoState stornoState = null;
            if (obj.getLong(15) != 0)
                stornoState = (PersistentStornoState)PersistentProxi.createProxi(obj.getLong(15), obj.getLong(16));
            Transfer result = new Transfer(subService,
                                           This,
                                           obj.getLong(6),
                                           obj.getLong(7),
                                           sender,
                                           money,
                                           obj.getString(12) == null ? "" : obj.getString(12) /* In Oracle "" = null !!! */,
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

