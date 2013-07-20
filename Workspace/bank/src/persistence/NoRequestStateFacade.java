package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NoRequestStateFacade{

	private String schemaName;
	private Connection con;

	public NoRequestStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NoRequestStateProxi getTheNoRequestState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NRqstSttFacade.getTheNRqstStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (NoRequestStateProxi)PersistentProxi.createProxi(id, 104);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoRequestState getNoRequestState(long NoRequestStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NRqstSttFacade.getNRqstStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NoRequestStateId);
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
            NoRequestState result = new NoRequestState(subService,
                                                       This,
                                                       NoRequestStateId);
            obj.close();
            callable.close();
            NoRequestStateICProxi inCache = (NoRequestStateICProxi)Cache.getTheCache().put(result);
            NoRequestState objectInCache = (NoRequestState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

