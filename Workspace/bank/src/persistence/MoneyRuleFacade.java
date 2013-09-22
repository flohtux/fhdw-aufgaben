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
            MoneyRule result = new MoneyRule(null,null,null,null,null,id);
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
            MoneyRule result = new MoneyRule(null,null,null,null,null,id);
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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentRule This = null;
            PersistentCurrency currency = null;
            PersistentAmount minLimit = null;
            PersistentAmount maxLimit = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10307: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10308: {
                        This = (PersistentRule)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10324: {
                        currency = (PersistentCurrency)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10333: {
                        minLimit = (PersistentAmount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10334: {
                        maxLimit = (PersistentAmount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            MoneyRule result = new MoneyRule(subService, 
                                             This, 
                                             currency, 
                                             minLimit, 
                                             maxLimit, 
                                             MoneyRuleId);
            links.close();
            callable.close();
            MoneyRuleICProxi inCache = (MoneyRuleICProxi)Cache.getTheCache().put(result);
            MoneyRule objectInCache = (MoneyRule)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void currencySet(long MoneyRuleId, PersistentCurrency currencyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MnRlFacade.crrncSet(?, ?, ?); end;");
            callable.setLong(1, MoneyRuleId);
            callable.setLong(2, currencyVal.getId());
            callable.setLong(3, currencyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void minLimitSet(long MoneyRuleId, PersistentAmount minLimitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MnRlFacade.mnLmtSet(?, ?, ?); end;");
            callable.setLong(1, MoneyRuleId);
            callable.setLong(2, minLimitVal.getId());
            callable.setLong(3, minLimitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void maxLimitSet(long MoneyRuleId, PersistentAmount maxLimitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MnRlFacade.mxLmtSet(?, ?, ?); end;");
            callable.setLong(1, MoneyRuleId);
            callable.setLong(2, maxLimitVal.getId());
            callable.setLong(3, maxLimitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

