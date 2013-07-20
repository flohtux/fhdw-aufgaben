package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class TemplateStateFacade{

	private String schemaName;
	private Connection con;

	public TemplateStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public TemplateStateProxi getTheTemplateState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TmpltSttFacade.getTheTmpltStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (TemplateStateProxi)PersistentProxi.createProxi(id, 138);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TemplateState getTemplateState(long TemplateStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TmpltSttFacade.getTmpltStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, TemplateStateId);
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
            TemplateState result = new TemplateState(state,
                                                     stornoState,
                                                     subService,
                                                     This,
                                                     TemplateStateId);
            obj.close();
            callable.close();
            TemplateStateICProxi inCache = (TemplateStateICProxi)Cache.getTheCache().put(result);
            TemplateState objectInCache = (TemplateState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

