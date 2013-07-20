package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NotSuccessfullStorneStateFacade{

	private String schemaName;
	private Connection con;

	public NotSuccessfullStorneStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NotSuccessfullStorneStateProxi getTheNotSuccessfullStorneState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NoSucStoStaFacade.getTheNoSucStoSta; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (NotSuccessfullStorneStateProxi)PersistentProxi.createProxi(id, 134);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotSuccessfullStorneState getNotSuccessfullStorneState(long NotSuccessfullStorneStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NoSucStoStaFacade.getNoSucStoSta(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NotSuccessfullStorneStateId);
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
            NotSuccessfullStorneState result = new NotSuccessfullStorneState(subService,
                                                                             This,
                                                                             NotSuccessfullStorneStateId);
            obj.close();
            callable.close();
            NotSuccessfullStorneStateICProxi inCache = (NotSuccessfullStorneStateICProxi)Cache.getTheCache().put(result);
            NotSuccessfullStorneState objectInCache = (NotSuccessfullStorneState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

