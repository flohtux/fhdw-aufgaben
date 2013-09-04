package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class SuccessfulStornoStateFacade{

	private String schemaName;
	private Connection con;

	public SuccessfulStornoStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public SuccessfulStornoStateProxi getTheSuccessfulStornoState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SucStoStaFacade.getTheSucStoSta; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (SuccessfulStornoStateProxi)PersistentProxi.createProxi(id, 123);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SuccessfulStornoState getSuccessfulStornoState(long SuccessfulStornoStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SucStoStaFacade.getSucStoSta(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, SuccessfulStornoStateId);
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
            SuccessfulStornoState result = new SuccessfulStornoState(subService, 
                                                                     This, 
                                                                     SuccessfulStornoStateId);
            links.close();
            callable.close();
            SuccessfulStornoStateICProxi inCache = (SuccessfulStornoStateICProxi)Cache.getTheCache().put(result);
            SuccessfulStornoState objectInCache = (SuccessfulStornoState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

