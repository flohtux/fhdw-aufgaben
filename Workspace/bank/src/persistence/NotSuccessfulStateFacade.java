package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NotSuccessfulStateFacade{

	private String schemaName;
	private Connection con;

	public NotSuccessfulStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NotSuccessfulStateProxi newNotSuccessfulState(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NotSucStateFacade.newNotSucState(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NotSuccessfulState result = new NotSuccessfulState(null,null,id);
            Cache.getTheCache().put(result);
            return (NotSuccessfulStateProxi)PersistentProxi.createProxi(id, 142);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotSuccessfulStateProxi newDelayedNotSuccessfulState() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NotSucStateFacade.newDelayedNotSucState(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NotSuccessfulState result = new NotSuccessfulState(null,null,id);
            Cache.getTheCache().put(result);
            return (NotSuccessfulStateProxi)PersistentProxi.createProxi(id, 142);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotSuccessfulState getNotSuccessfulState(long NotSuccessfulStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NotSucStateFacade.getNotSucState(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NotSuccessfulStateId);
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
            PersistentDebitTransferState This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentDebitTransferState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            NotSuccessfulState result = new NotSuccessfulState(subService,
                                                               This,
                                                               NotSuccessfulStateId);
            obj.close();
            callable.close();
            NotSuccessfulStateICProxi inCache = (NotSuccessfulStateICProxi)Cache.getTheCache().put(result);
            NotSuccessfulState objectInCache = (NotSuccessfulState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

