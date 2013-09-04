package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class DebitTransferTransactionFacade{

	private String schemaName;
	private Connection con;

	public DebitTransferTransactionFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DebiTrfTranFacade.getClass(?); end;");
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
    public void timestampSet(long DebitTransferTransactionId, java.sql.Timestamp timestampVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebiTrfTranFacade.tmstmpSet(?, ?); end;");
            callable.setLong(1, DebitTransferTransactionId);
            callable.setTimestamp(2, timestampVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subjectSet(long DebitTransferTransactionId, String subjectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebiTrfTranFacade.sbjctSet(?, ?); end;");
            callable.setLong(1, DebitTransferTransactionId);
            callable.setString(2, subjectVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void senderSet(long DebitTransferTransactionId, PersistentAccount senderVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebiTrfTranFacade.sndrSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferTransactionId);
            callable.setLong(2, senderVal.getId());
            callable.setLong(3, senderVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void stateSet(long DebitTransferTransactionId, PersistentDebitTransferState stateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebiTrfTranFacade.sttSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferTransactionId);
            callable.setLong(2, stateVal.getId());
            callable.setLong(3, stateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long DebitTransferTransactionId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebiTrfTranFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferTransactionId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitTransferTransactionId, PersistentDebitTransferTransaction ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebiTrfTranFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferTransactionId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferTransactionSearchList inverseGetState(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DebiTrfTranFacade.iGetStt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitTransferTransactionSearchList result = new DebitTransferTransactionSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentDebitTransferTransaction)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentDebitTransferTransaction)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

