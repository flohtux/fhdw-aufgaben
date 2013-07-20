package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class DebitNoteTransferStateFacade{

	private String schemaName;
	private Connection con;

	public DebitNoteTransferStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DebiTraStatFacade.getClass(?); end;");
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
    public void stateSet(long DebitNoteTransferStateId, PersistentDebitNoteTransferState stateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebiTraStatFacade.sttSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransferStateId);
            callable.setLong(2, stateVal.getId());
            callable.setLong(3, stateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void stornoStateSet(long DebitNoteTransferStateId, PersistentStornoState stornoStateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebiTraStatFacade.strnSttSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransferStateId);
            callable.setLong(2, stornoStateVal.getId());
            callable.setLong(3, stornoStateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long DebitNoteTransferStateId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebiTraStatFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransferStateId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitNoteTransferStateId, PersistentDebitNoteTransferState ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebiTraStatFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitNoteTransferStateId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitNoteTransferStateSearchList inverseGetState(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DebiTraStatFacade.iGetStt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitNoteTransferStateSearchList result = new DebitNoteTransferStateSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentDebitNoteTransferState)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentDebitNoteTransferState)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitNoteTransferStateSearchList inverseGetStornoState(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DebiTraStatFacade.iGetStrnStt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitNoteTransferStateSearchList result = new DebitNoteTransferStateSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentDebitNoteTransferState)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentDebitNoteTransferState)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

