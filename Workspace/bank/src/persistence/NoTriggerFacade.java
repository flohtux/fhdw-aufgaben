package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NoTriggerFacade{

	private String schemaName;
	private Connection con;

	public NoTriggerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NoTriggerProxi newNoTrigger(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NTrggrFacade.newNTrggr(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NoTrigger result = new NoTrigger(null,null,id);
            Cache.getTheCache().put(result);
            return (NoTriggerProxi)PersistentProxi.createProxi(id, 246);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoTriggerProxi newDelayedNoTrigger() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NTrggrFacade.newDelayedNTrggr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NoTrigger result = new NoTrigger(null,null,id);
            Cache.getTheCache().put(result);
            return (NoTriggerProxi)PersistentProxi.createProxi(id, 246);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoTrigger getNoTrigger(long NoTriggerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NTrggrFacade.getNTrggr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NoTriggerId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentTriggerValue This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10347: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10348: {
                        This = (PersistentTriggerValue)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            NoTrigger result = new NoTrigger(subService, 
                                             This, 
                                             NoTriggerId);
            links.close();
            callable.close();
            NoTriggerICProxi inCache = (NoTriggerICProxi)Cache.getTheCache().put(result);
            NoTrigger objectInCache = (NoTrigger)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

