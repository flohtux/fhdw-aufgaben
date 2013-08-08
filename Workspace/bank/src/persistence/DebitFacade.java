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

    public DebitProxi getTheDebit() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtFacade.getTheDbt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
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
            SubjInterface subService = null;
            if (obj.getLong(3) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentDebitTransferTransaction This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentAccount sender = null;
            if (obj.getLong(9) != 0)
                sender = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentMoney money = null;
            if (obj.getLong(11) != 0)
                money = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            PersistentDebitTransferState state = null;
            if (obj.getLong(14) != 0)
                state = (PersistentDebitTransferState)PersistentProxi.createProxi(obj.getLong(14), obj.getLong(15));
            PersistentStornoState stornoState = null;
            if (obj.getLong(16) != 0)
                stornoState = (PersistentStornoState)PersistentProxi.createProxi(obj.getLong(16), obj.getLong(17));
            Debit result = new Debit(obj.getTimestamp(2),
                                     subService,
                                     This,
                                     obj.getLong(7),
                                     obj.getLong(8),
                                     sender,
                                     money,
                                     obj.getString(13) == null ? "" : obj.getString(13) /* In Oracle "" = null !!! */,
                                     state,
                                     stornoState,
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

