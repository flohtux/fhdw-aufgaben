package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NotExecutetStateFacade{

	private String schemaName;
	private Connection con;

	public NotExecutetStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NotExecutetStateProxi getTheNotExecutetState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExcttSttFacade.getTheNtExcttStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (NotExecutetStateProxi)PersistentProxi.createProxi(id, 143);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotExecutetState getNotExecutetState(long NotExecutetStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExcttSttFacade.getNtExcttStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NotExecutetStateId);
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
            NotExecutetState result = new NotExecutetState(state,
                                                           stornoState,
                                                           subService,
                                                           This,
                                                           NotExecutetStateId);
            obj.close();
            callable.close();
            NotExecutetStateICProxi inCache = (NotExecutetStateICProxi)Cache.getTheCache().put(result);
            NotExecutetState objectInCache = (NotExecutetState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

