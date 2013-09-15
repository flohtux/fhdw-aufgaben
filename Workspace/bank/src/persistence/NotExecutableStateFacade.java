package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NotExecutableStateFacade{

	private String schemaName;
	private Connection con;

	public NotExecutableStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NotExecutableStateProxi newNotExecutableState(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctblSttFacade.newNtExctblStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NotExecutableState result = new NotExecutableState(null,null,id);
            Cache.getTheCache().put(result);
            return (NotExecutableStateProxi)PersistentProxi.createProxi(id, 144);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotExecutableStateProxi newDelayedNotExecutableState() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctblSttFacade.newDelayedNtExctblStt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NotExecutableState result = new NotExecutableState(null,null,id);
            Cache.getTheCache().put(result);
            return (NotExecutableStateProxi)PersistentProxi.createProxi(id, 144);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NotExecutableState getNotExecutableState(long NotExecutableStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NtExctblSttFacade.getNtExctblStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NotExecutableStateId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentDebitTransferState This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10092: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10093: {
                        This = (PersistentDebitTransferState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            NotExecutableState result = new NotExecutableState(subService, 
                                                               This, 
                                                               NotExecutableStateId);
            links.close();
            callable.close();
            NotExecutableStateICProxi inCache = (NotExecutableStateICProxi)Cache.getTheCache().put(result);
            NotExecutableState objectInCache = (NotExecutableState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

