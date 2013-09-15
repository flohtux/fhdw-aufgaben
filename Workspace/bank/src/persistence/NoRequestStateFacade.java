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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentStornoState This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10010: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10011: {
                        This = (PersistentStornoState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            NoRequestState result = new NoRequestState(subService, 
                                                       This, 
                                                       NoRequestStateId);
            links.close();
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

