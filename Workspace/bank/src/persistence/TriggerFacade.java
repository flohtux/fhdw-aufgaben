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
            Trigger result = new Trigger(null,null,name,null,null,id);
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
            Trigger result = new Trigger(null,null,name,null,null,id);
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
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentTriggerValue This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentTriggerValue)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentTriggerState state = null;
            if (obj.getLong(7) != 0)
                state = (PersistentTriggerState)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentDebitTransferTransaction action = null;
            if (obj.getLong(9) != 0)
                action = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            Trigger result = new Trigger(subService,
                                         This,
                                         obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                         state,
                                         action,
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
    public void stateSet(long TriggerId, PersistentTriggerState stateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrggrFacade.sttSet(?, ?, ?); end;");
            callable.setLong(1, TriggerId);
            callable.setLong(2, stateVal.getId());
            callable.setLong(3, stateVal.getClassId());
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
    public TriggerSearchList inverseGetState(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrggrFacade.iGetStt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            TriggerSearchList result = new TriggerSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentTrigger)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentTrigger)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public TriggerSearchList inverseGetRules(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrggrFacade.iGetRls(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            TriggerSearchList result = new TriggerSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentTrigger)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentTrigger)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

