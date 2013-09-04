package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MoneyRuleFacade{

	private String schemaName;
	private Connection con;

	public MoneyRuleFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MoneyRuleProxi newMoneyRule(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MnRlFacade.newMnRl(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MoneyRule result = new MoneyRule(null,null,null,id);
            Cache.getTheCache().put(result);
            return (MoneyRuleProxi)PersistentProxi.createProxi(id, 232);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MoneyRuleProxi newDelayedMoneyRule() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MnRlFacade.newDelayedMnRl(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MoneyRule result = new MoneyRule(null,null,null,id);
            Cache.getTheCache().put(result);
            return (MoneyRuleProxi)PersistentProxi.createProxi(id, 232);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MoneyRule getMoneyRule(long MoneyRuleId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MnRlFacade.getMnRl(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MoneyRuleId);
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
            PersistentRule This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentRule)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentLimitType limitType = null;
            if (obj.getLong(6) != 0)
                limitType = (PersistentLimitType)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            MoneyRule result = new MoneyRule(subService,
                                             This,
                                             limitType,
                                             MoneyRuleId);
            obj.close();
            callable.close();
            MoneyRuleICProxi inCache = (MoneyRuleICProxi)Cache.getTheCache().put(result);
            MoneyRule objectInCache = (MoneyRule)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void limitTypeSet(long MoneyRuleId, PersistentLimitType limitTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MnRlFacade.lmtTpSet(?, ?, ?); end;");
            callable.setLong(1, MoneyRuleId);
            callable.setLong(2, limitTypeVal.getId());
            callable.setLong(3, limitTypeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

