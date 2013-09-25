package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DeclinedCompensationStateFacade{

	private String schemaName;
	private Connection con;

	public DeclinedCompensationStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DeclinedCompensationStateProxi getTheDeclinedCompensationState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DecComStaFacade.getTheDecComSta; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (DeclinedCompensationStateProxi)PersistentProxi.createProxi(id, 281);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DeclinedCompensationState getDeclinedCompensationState(long DeclinedCompensationStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DecComStaFacade.getDecComSta(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DeclinedCompensationStateId);
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
            PersistentCompensationState This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentCompensationState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            DeclinedCompensationState result = new DeclinedCompensationState(subService,
                                                                             This,
                                                                             DeclinedCompensationStateId);
            obj.close();
            callable.close();
            DeclinedCompensationStateICProxi inCache = (DeclinedCompensationStateICProxi)Cache.getTheCache().put(result);
            DeclinedCompensationState objectInCache = (DeclinedCompensationState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

