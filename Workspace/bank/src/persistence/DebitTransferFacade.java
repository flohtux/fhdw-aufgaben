package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class DebitTransferFacade{

	private String schemaName;
	private Connection con;

	public DebitTransferFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public void receiverAccountNumberSet(long DebitTransferId, long receiverAccountNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnsfrFacade.recaccnoSet(?, ?); end;");
            callable.setLong(1, DebitTransferId);
            callable.setLong(2, receiverAccountNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void receiverBankNumberSet(long DebitTransferId, long receiverBankNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnsfrFacade.rcvrBnkNmbrSet(?, ?); end;");
            callable.setLong(1, DebitTransferId);
            callable.setLong(2, receiverBankNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moneySet(long DebitTransferId, PersistentMoney moneyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnsfrFacade.mnSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferId);
            callable.setLong(2, moneyVal.getId());
            callable.setLong(3, moneyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerTriggerSet(long DebitTransferId, PersistentTriggerValue invokerTriggerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnsfrFacade.invkrTrggrSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferId);
            callable.setLong(2, invokerTriggerVal.getId());
            callable.setLong(3, invokerTriggerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long nextDebitTransferTransactionstriggersAdd(long DebitTransferId, PersistentDebitTransferTransaction nextDebitTransferTransactionstriggersVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtTrnsfrFacade.nxtdtttrgAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, DebitTransferId);
            callable.setLong(3, nextDebitTransferTransactionstriggersVal.getId());
            callable.setLong(4, nextDebitTransferTransactionstriggersVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nextDebitTransferTransactionstriggersRem(long nextDebitTransferTransactionstriggersId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnsfrFacade.nxtdtttrgRem(?); end;");
            callable.setLong(1, nextDebitTransferTransactionstriggersId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferTransactionList nextDebitTransferTransactionstriggersGet(long DebitTransferId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtTrnsfrFacade.nxtdtttrgGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitTransferId);
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
    public void previousDebitTransferSet(long DebitTransferId, PersistentDebitTransfer previousDebitTransferVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnsfrFacade.prvdebtraSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferId);
            callable.setLong(2, previousDebitTransferVal.getId());
            callable.setLong(3, previousDebitTransferVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

