package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class EnabledStateFacade{

	private String schemaName;
	private Connection con;

	public EnabledStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public EnabledStateProxi getTheEnabledState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".EnbldSttFacade.getTheEnbldStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (EnabledStateProxi)PersistentProxi.createProxi(id, 238);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public EnabledState getEnabledState(long EnabledStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".EnbldSttFacade.getEnbldStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, EnabledStateId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentTriggerState This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10320: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10321: {
                        This = (PersistentTriggerState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            EnabledState result = new EnabledState(subService, 
                                                   This, 
                                                   EnabledStateId);
            links.close();
            callable.close();
            EnabledStateICProxi inCache = (EnabledStateICProxi)Cache.getTheCache().put(result);
            EnabledState objectInCache = (EnabledState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

