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
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentDebitTransferTransaction action = null;
            if (obj.getLong(3) != 0)
                action = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            SubjInterface subService = null;
            if (obj.getLong(5) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentTrigger This = null;
            if (obj.getLong(7) != 0)
                This = (PersistentTrigger)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            Trigger result = new Trigger(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                         action,
                                         subService,
                                         This,
                                         TriggerId);
            obj.close();
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

