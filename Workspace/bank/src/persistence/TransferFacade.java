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

    public TransferProxi newTransfer(java.sql.Timestamp timestamp,String subject,long receiverAccountNumber,long receiverBankNumber,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newTrnsfr(?,?,?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setTimestamp(2, timestamp);
            callable.setString(3, subject);
            callable.setLong(4, receiverAccountNumber);
            callable.setLong(5, receiverBankNumber);
            callable.setLong(6, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(timestamp,subject,null,null,null,null,receiverAccountNumber,receiverBankNumber,null,null,id);
            Cache.getTheCache().put(result);
            return (TransferProxi)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TransferProxi newDelayedTransfer(java.sql.Timestamp timestamp,String subject,long receiverAccountNumber,long receiverBankNumber) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newDelayedTrnsfr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(timestamp,subject,null,null,null,null,receiverAccountNumber,receiverBankNumber,null,null,id);
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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
            String subject = "";
            PersistentAccount sender = null;
            PersistentDebitTransferState state = null;
            SubjInterface subService = null;
            PersistentDebitTransferTransaction This = null;
            long receiverAccountNumber = 0;
            long receiverBankNumber = 0;
            PersistentMoney money = null;
            PersistentStornoState stornoState = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10127: {
                        timestamp = links.getTimestamp(9);
                        break;
                    }
                    case 10309: {
                        subject = links.getString(6);
                        if(subject == null)subject = "";
                        break;
                    }
                    case 10242: {
                        sender = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10241: {
                        state = (PersistentDebitTransferState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10076: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10077: {
                        This = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10130: {
                        receiverAccountNumber = links.getLong(5);
                        break;
                    }
                    case 10131: {
                        receiverBankNumber = links.getLong(5);
                        break;
                    }
                    case 10133: {
                        money = (PersistentMoney)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10136: {
                        stornoState = (PersistentStornoState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            Transfer result = new Transfer(timestamp, 
                                           subject, 
                                           sender, 
                                           state, 
                                           subService, 
                                           This, 
                                           receiverAccountNumber, 
                                           receiverBankNumber, 
                                           money, 
                                           stornoState, 
                                           TransferId);
            links.close();
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

