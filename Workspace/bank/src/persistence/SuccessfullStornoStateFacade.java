package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class SuccessfullStornoStateFacade{

	private String schemaName;
	private Connection con;

	public SuccessfullStornoStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public SuccessfullStornoStateProxi getTheSuccessfullStornoState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SucStoStaFacade.getTheSucStoSta; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (SuccessfullStornoStateProxi)PersistentProxi.createProxi(id, 123);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SuccessfullStornoState getSuccessfullStornoState(long SuccessfullStornoStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SucStoStaFacade.getSucStoSta(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, SuccessfullStornoStateId);
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
            PersistentStornoState This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentStornoState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SuccessfullStornoState result = new SuccessfullStornoState(subService,
                                                                       This,
                                                                       SuccessfullStornoStateId);
            obj.close();
            callable.close();
            SuccessfullStornoStateICProxi inCache = (SuccessfullStornoStateICProxi)Cache.getTheCache().put(result);
            SuccessfullStornoState objectInCache = (SuccessfullStornoState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

