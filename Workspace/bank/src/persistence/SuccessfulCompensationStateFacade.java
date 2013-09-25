package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class SuccessfulCompensationStateFacade{

	private String schemaName;
	private Connection con;

	public SuccessfulCompensationStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public SuccessfulCompensationStateProxi getTheSuccessfulCompensationState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SuccComStaFacade.getTheSuccComSta; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (SuccessfulCompensationStateProxi)PersistentProxi.createProxi(id, 279);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SuccessfulCompensationState getSuccessfulCompensationState(long SuccessfulCompensationStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SuccComStaFacade.getSuccComSta(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, SuccessfulCompensationStateId);
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
            SuccessfulCompensationState result = new SuccessfulCompensationState(subService,
                                                                                 This,
                                                                                 SuccessfulCompensationStateId);
            obj.close();
            callable.close();
            SuccessfulCompensationStateICProxi inCache = (SuccessfulCompensationStateICProxi)Cache.getTheCache().put(result);
            SuccessfulCompensationState objectInCache = (SuccessfulCompensationState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

