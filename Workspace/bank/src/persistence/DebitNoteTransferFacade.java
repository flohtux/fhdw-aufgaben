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
    public void receiverSet(long DebitNoteTransferId, PersistentAccount receiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtNtTrnsfrFacade.rcvrSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransferId);
            callable.setLong(2, receiverVal.getId());
            callable.setLong(3, receiverVal.getClassId());
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

}

