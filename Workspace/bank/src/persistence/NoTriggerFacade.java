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
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentTriggerValue This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentTriggerValue)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            NoTrigger result = new NoTrigger(subService,
                                             This,
                                             NoTriggerId);
            obj.close();
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

