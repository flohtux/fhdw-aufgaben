package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MinLimitStateFacade{

	private String schemaName;
	private Connection con;

	public MinLimitStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MinLimitStateProxi getTheMinLimitState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MnLmtSttFacade.getTheMnLmtStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (MinLimitStateProxi)PersistentProxi.createProxi(id, 143);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MinLimitState getMinLimitState(long MinLimitStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MnLmtSttFacade.getMnLmtStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MinLimitStateId);
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
            PersistentAmount balance = null;
            if (obj.getLong(6) != 0)
                balance = (PersistentAmount)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            MinLimitState result = new MinLimitState(subService,
                                                     This,
                                                     balance,
                                                     MinLimitStateId);
            obj.close();
            callable.close();
            MinLimitStateICProxi inCache = (MinLimitStateICProxi)Cache.getTheCache().put(result);
            MinLimitState objectInCache = (MinLimitState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

