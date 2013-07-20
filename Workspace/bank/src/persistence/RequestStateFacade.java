package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class RequestStateFacade{

	private String schemaName;
	private Connection con;

	public RequestStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public RequestStateProxi getTheRequestState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RqstSttFacade.getTheRqstStt; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (RequestStateProxi)PersistentProxi.createProxi(id, 131);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public RequestState getRequestState(long RequestStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RqstSttFacade.getRqstStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, RequestStateId);
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
            RequestState result = new RequestState(subService,
                                                   This,
                                                   RequestStateId);
            obj.close();
            callable.close();
            RequestStateICProxi inCache = (RequestStateICProxi)Cache.getTheCache().put(result);
            RequestState objectInCache = (RequestState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

