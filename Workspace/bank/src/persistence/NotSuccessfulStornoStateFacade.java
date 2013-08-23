package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NotSuccessfulStornoStateFacade{

	private String schemaName;
	private Connection con;

	public NotSuccessfulStornoStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NotSuccessfulStornoStateProxi getTheNotSuccessfulStornoState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NoSucStoStaFacade.getTheNoSucStoSta; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (NotSuccessfulStornoStateProxi)PersistentProxi.createProxi(id, 134);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotSuccessfulStornoState getNotSuccessfulStornoState(long NotSuccessfulStornoStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NoSucStoStaFacade.getNoSucStoSta(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NotSuccessfulStornoStateId);
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
            NotSuccessfulStornoState result = new NotSuccessfulStornoState(subService,
                                                                           This,
                                                                           NotSuccessfulStornoStateId);
            obj.close();
            callable.close();
            NotSuccessfulStornoStateICProxi inCache = (NotSuccessfulStornoStateICProxi)Cache.getTheCache().put(result);
            NotSuccessfulStornoState objectInCache = (NotSuccessfulStornoState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

