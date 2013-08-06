package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DebitNoteFacade{

	private String schemaName;
	private Connection con;

	public DebitNoteFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DebitNoteProxi getTheDebitNote() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtNtFacade.getTheDbtNt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (DebitNoteProxi)PersistentProxi.createProxi(id, 136);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitNote getDebitNote(long DebitNoteId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtNtFacade.getDbtNt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitNoteId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(3) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentDebitNoteTransferTransaction This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentDebitNoteTransferTransaction)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentAccount sender = null;
            if (obj.getLong(9) != 0)
                sender = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentMoney money = null;
            if (obj.getLong(11) != 0)
                money = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            PersistentDebitNoteTransferState state = null;
            if (obj.getLong(13) != 0)
                state = (PersistentDebitNoteTransferState)PersistentProxi.createProxi(obj.getLong(13), obj.getLong(14));
            PersistentStornoState stornoState = null;
            if (obj.getLong(15) != 0)
                stornoState = (PersistentStornoState)PersistentProxi.createProxi(obj.getLong(15), obj.getLong(16));
            DebitNote result = new DebitNote(obj.getTimestamp(2),
                                             subService,
                                             This,
                                             obj.getLong(7),
                                             obj.getLong(8),
                                             sender,
                                             money,
                                             state,
                                             stornoState,
                                             DebitNoteId);
            obj.close();
            callable.close();
            DebitNoteICProxi inCache = (DebitNoteICProxi)Cache.getTheCache().put(result);
            DebitNote objectInCache = (DebitNote)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

