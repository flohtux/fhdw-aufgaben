package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DisabledStateFacade{

	private String schemaName;
	private Connection con;

	public DisabledStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DisabledStateProxi getTheDisabledState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DsbldSttFacade.getTheDsbldStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (DisabledStateProxi)PersistentProxi.createProxi(id, 237);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DisabledState getDisabledState(long DisabledStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DsbldSttFacade.getDsbldStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DisabledStateId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentTriggerState This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentTriggerState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            DisabledState result = new DisabledState(subService,
                                                     This,
                                                     DisabledStateId);
            obj.close();
            callable.close();
            DisabledStateICProxi inCache = (DisabledStateICProxi)Cache.getTheCache().put(result);
            DisabledState objectInCache = (DisabledState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

