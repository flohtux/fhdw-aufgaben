package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class DebitNoteTransferFacade{

	private String schemaName;
	private Connection con;

	public DebitNoteTransferFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public void receiverAccountNumberSet(long DebitNoteTransferId, long receiverAccountNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtNtTrnsfrFacade.recaccnoSet(?, ?); end;");
            callable.setLong(1, DebitNoteTransferId);
            callable.setLong(2, receiverAccountNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void receiverBankNumberSet(long DebitNoteTransferId, long receiverBankNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtNtTrnsfrFacade.rcvrBnkNmbrSet(?, ?); end;");
            callable.setLong(1, DebitNoteTransferId);
            callable.setLong(2, receiverBankNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void senderSet(long DebitNoteTransferId, PersistentAccount senderVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtNtTrnsfrFacade.sndrSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransferId);
            callable.setLong(2, senderVal.getId());
            callable.setLong(3, senderVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moneySet(long DebitNoteTransferId, PersistentMoney moneyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtNtTrnsfrFacade.mnSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransferId);
            callable.setLong(2, moneyVal.getId());
            callable.setLong(3, moneyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void stateSet(long DebitNoteTransferId, PersistentDebitNoteTransferState stateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtNtTrnsfrFacade.sttSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransferId);
            callable.setLong(2, stateVal.getId());
            callable.setLong(3, stateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void stornoStateSet(long DebitNoteTransferId, PersistentStornoState stornoStateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtNtTrnsfrFacade.strnSttSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransferId);
            callable.setLong(2, stornoStateVal.getId());
            callable.setLong(3, stornoStateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitNoteTransferSearchList inverseGetState(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtNtTrnsfrFacade.iGetStt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitNoteTransferSearchList result = new DebitNoteTransferSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentDebitNoteTransfer)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentDebitNoteTransfer)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitNoteTransferSearchList inverseGetStornoState(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtNtTrnsfrFacade.iGetStrnStt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitNoteTransferSearchList result = new DebitNoteTransferSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentDebitNoteTransfer)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentDebitNoteTransfer)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

