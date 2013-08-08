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
    public void senderSet(long DebitTransferId, PersistentAccount senderVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnsfrFacade.sndrSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferId);
            callable.setLong(2, senderVal.getId());
            callable.setLong(3, senderVal.getClassId());
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
    public void subjectSet(long DebitTransferId, String subjectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnsfrFacade.sbjctSet(?, ?); end;");
            callable.setLong(1, DebitTransferId);
            callable.setString(2, subjectVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void stateSet(long DebitTransferId, PersistentDebitTransferState stateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnsfrFacade.sttSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferId);
            callable.setLong(2, stateVal.getId());
            callable.setLong(3, stateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void stornoStateSet(long DebitTransferId, PersistentStornoState stornoStateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnsfrFacade.strnSttSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferId);
            callable.setLong(2, stornoStateVal.getId());
            callable.setLong(3, stornoStateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferSearchList inverseGetState(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtTrnsfrFacade.iGetStt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitTransferSearchList result = new DebitTransferSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentDebitTransfer)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentDebitTransfer)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferSearchList inverseGetStornoState(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtTrnsfrFacade.iGetStrnStt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitTransferSearchList result = new DebitTransferSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentDebitTransfer)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentDebitTransfer)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

