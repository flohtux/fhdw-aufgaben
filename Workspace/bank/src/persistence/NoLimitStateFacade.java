package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NoLimitStateFacade{

	private String schemaName;
	private Connection con;

	public NoLimitStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NoLimitStateProxi getTheNoLimitState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NLmtSttFacade.getTheNLmtStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (NoLimitStateProxi)PersistentProxi.createProxi(id, 140);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoLimitState getNoLimitState(long NoLimitStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NLmtSttFacade.getNLmtStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NoLimitStateId);
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
            PersistentAccountLimitState This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentAccountLimitState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            NoLimitState result = new NoLimitState(subService,
                                                   This,
                                                   NoLimitStateId);
            obj.close();
            callable.close();
            NoLimitStateICProxi inCache = (NoLimitStateICProxi)Cache.getTheCache().put(result);
            NoLimitState objectInCache = (NoLimitState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

