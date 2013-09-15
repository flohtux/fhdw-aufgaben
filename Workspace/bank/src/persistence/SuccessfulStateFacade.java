package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class SuccessfulStateFacade{

	private String schemaName;
	private Connection con;

	public SuccessfulStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public SuccessfulStateProxi newSuccessfulState(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SccssflSttFacade.newSccssflStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SuccessfulState result = new SuccessfulState(null,null,id);
            Cache.getTheCache().put(result);
            return (SuccessfulStateProxi)PersistentProxi.createProxi(id, 175);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SuccessfulStateProxi newDelayedSuccessfulState() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SccssflSttFacade.newDelayedSccssflStt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SuccessfulState result = new SuccessfulState(null,null,id);
            Cache.getTheCache().put(result);
            return (SuccessfulStateProxi)PersistentProxi.createProxi(id, 175);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SuccessfulState getSuccessfulState(long SuccessfulStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SccssflSttFacade.getSccssflStt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, SuccessfulStateId);
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
            SuccessfulState result = new SuccessfulState(subService, 
                                                         This, 
                                                         SuccessfulStateId);
            links.close();
            callable.close();
            SuccessfulStateICProxi inCache = (SuccessfulStateICProxi)Cache.getTheCache().put(result);
            SuccessfulState objectInCache = (SuccessfulState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

