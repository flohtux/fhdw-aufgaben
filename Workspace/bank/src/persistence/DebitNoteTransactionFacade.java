package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class DebitNoteTransactionFacade{

	private String schemaName;
	private Connection con;

	public DebitNoteTransactionFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DebitTransFacade.getClass(?); end;");
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
    public void bankNumberSet(long DebitNoteTransactionId, long bankNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebitTransFacade.bnkNmbrSet(?, ?); end;");
            callable.setLong(1, DebitNoteTransactionId);
            callable.setLong(2, bankNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void accountNumberSet(long DebitNoteTransactionId, long accountNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebitTransFacade.accntNmbrSet(?, ?); end;");
            callable.setLong(1, DebitNoteTransactionId);
            callable.setLong(2, accountNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moneySet(long DebitNoteTransactionId, PersistentMoney moneyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebitTransFacade.mnSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransactionId);
            callable.setLong(2, moneyVal.getId());
            callable.setLong(3, moneyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long DebitNoteTransactionId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebitTransFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransactionId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitNoteTransactionId, PersistentDebitNoteTransaction ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebitTransFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransactionId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

