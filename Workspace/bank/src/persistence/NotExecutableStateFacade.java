package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NotExecutableStateFacade{

	private String schemaName;
	private Connection con;

	public NotExecutableStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NotExecutableStateProxi getTheNotExecutableState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctblSttFacade.getTheNtExctblStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (NotExecutableStateProxi)PersistentProxi.createProxi(id, 144);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotExecutableState getNotExecutableState(long NotExecutableStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctblSttFacade.getNtExctblStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NotExecutableStateId);
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
            NotExecutableState result = new NotExecutableState(state,
                                                               stornoState,
                                                               subService,
                                                               This,
                                                               NotExecutableStateId);
            obj.close();
            callable.close();
            NotExecutableStateICProxi inCache = (NotExecutableStateICProxi)Cache.getTheCache().put(result);
            NotExecutableState objectInCache = (NotExecutableState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

