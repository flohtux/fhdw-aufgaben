package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DebitFacade{

	private String schemaName;
	private Connection con;

	public DebitFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DebitProxi newDebit(java.sql.Timestamp timestamp,String subject,long receiverAccountNumber,long receiverBankNumber,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtFacade.newDbt(?,?,?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setTimestamp(2, timestamp);
            callable.setString(3, subject);
            callable.setLong(4, receiverAccountNumber);
            callable.setLong(5, receiverBankNumber);
            callable.setLong(6, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Debit result = new Debit(timestamp,subject,null,null,null,null,receiverAccountNumber,receiverBankNumber,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (DebitProxi)PersistentProxi.createProxi(id, 177);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitProxi newDelayedDebit(java.sql.Timestamp timestamp,String subject,long receiverAccountNumber,long receiverBankNumber) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtFacade.newDelayedDbt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Debit result = new Debit(timestamp,subject,null,null,null,null,receiverAccountNumber,receiverBankNumber,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (DebitProxi)PersistentProxi.createProxi(id, 177);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Debit getDebit(long DebitId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtFacade.getDbt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitId);
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
            PersistentAccount receiver = null;
            if (obj.getLong(14) != 0)
                receiver = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(14), obj.getLong(15));
            PersistentMoney money = null;
            if (obj.getLong(16) != 0)
                money = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(16), obj.getLong(17));
            PersistentTriggerValue invokerTrigger = null;
            if (obj.getLong(18) != 0)
                invokerTrigger = (PersistentTriggerValue)PersistentProxi.createProxi(obj.getLong(18), obj.getLong(19));
            DebitTransferNoValue previousDebitTransfer = null;
            if (obj.getLong(20) != 0)
                previousDebitTransfer = (DebitTransferNoValue)PersistentProxi.createProxi(obj.getLong(20), obj.getLong(21));
            Debit result = new Debit(obj.getTimestamp(2),
                                     obj.getString(3) == null ? "" : obj.getString(3) /* In Oracle "" = null !!! */,
                                     sender,
                                     state,
                                     subService,
                                     This,
                                     obj.getLong(12),
                                     obj.getLong(13),
                                     receiver,
                                     money,
                                     invokerTrigger,
                                     previousDebitTransfer,
                                     DebitId);
            obj.close();
            callable.close();
            DebitICProxi inCache = (DebitICProxi)Cache.getTheCache().put(result);
            Debit objectInCache = (Debit)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

