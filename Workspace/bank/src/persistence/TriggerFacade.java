package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class TriggerFacade{

	private String schemaName;
	private Connection con;

	public TriggerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public TriggerProxi newTrigger(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrggrFacade.newTrggr(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Trigger result = new Trigger(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (TriggerProxi)PersistentProxi.createProxi(id, 231);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TriggerProxi newDelayedTrigger(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrggrFacade.newDelayedTrggr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Trigger result = new Trigger(name,null,null,null,id);
            Cache.getTheCache().put(result);
            return (TriggerProxi)PersistentProxi.createProxi(id, 231);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Trigger getTrigger(long TriggerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrggrFacade.getTrggr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, TriggerId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            String name = "";
            PersistentDebitTransferTransaction action = null;
            SubjInterface subService = null;
            PersistentTrigger This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10301: {
                        name = links.getString(6);
                        if(name == null)name = "";
                        break;
                    }
                    case 10302: {
                        action = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10304: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10305: {
                        This = (PersistentTrigger)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            Trigger result = new Trigger(name, 
                                         action, 
                                         subService, 
                                         This, 
                                         TriggerId);
            links.close();
            callable.close();
            TriggerICProxi inCache = (TriggerICProxi)Cache.getTheCache().put(result);
            Trigger objectInCache = (Trigger)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrggrFacade.getClass(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long TriggerId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrggrFacade.nmSet(?, ?); end;");
            callable.setLong(1, TriggerId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void actionSet(long TriggerId, PersistentDebitTransferTransaction actionVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrggrFacade.actnSet(?, ?, ?); end;");
            callable.setLong(1, TriggerId);
            callable.setLong(2, actionVal.getId());
            callable.setLong(3, actionVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long rulesAdd(long TriggerId, PersistentRule rulesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrggrFacade.rlsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, TriggerId);
            callable.setLong(3, rulesVal.getId());
            callable.setLong(4, rulesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void rulesRem(long rulesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrggrFacade.rlsRem(?); end;");
            callable.setLong(1, rulesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public RuleList rulesGet(long TriggerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrggrFacade.rlsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, TriggerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            RuleList result = new RuleList();
            while (list.next()) {
                result.add((PersistentRule)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long TriggerId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrggrFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, TriggerId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long TriggerId, PersistentTrigger ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrggrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, TriggerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

