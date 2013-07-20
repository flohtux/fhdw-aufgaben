package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class SuccessfullStateFacade{

	private String schemaName;
	private Connection con;

	public SuccessfullStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public SuccessfullStateProxi getTheSuccessfullState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SccssfllSttFacade.getTheSccssfllStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (SuccessfullStateProxi)PersistentProxi.createProxi(id, 113);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SuccessfullState getSuccessfullState(long SuccessfullStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SccssfllSttFacade.getSccssfllStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, SuccessfullStateId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentDebitNoteTransferState state = null;
            if (obj.getLong(2) != 0)
                state = (PersistentDebitNoteTransferState)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentStornoState stornoState = null;
            if (obj.getLong(4) != 0)
                stornoState = (PersistentStornoState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentDebitNoteTransferState This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentDebitNoteTransferState)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            SuccessfullState result = new SuccessfullState(state,
                                                           stornoState,
                                                           subService,
                                                           This,
                                                           SuccessfullStateId);
            obj.close();
            callable.close();
            SuccessfullStateICProxi inCache = (SuccessfullStateICProxi)Cache.getTheCache().put(result);
            SuccessfullState objectInCache = (SuccessfullState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

