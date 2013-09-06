package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class IncomingAccountRuleFacade{

	private String schemaName;
	private Connection con;

	public IncomingAccountRuleFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public IncomingAccountRuleProxi newIncomingAccountRule(long accountNumber,long bankNumber,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".IncAccRuleFacade.newIncAccRule(?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, accountNumber);
            callable.setLong(3, bankNumber);
            callable.setLong(4, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            IncomingAccountRule result = new IncomingAccountRule(null,null,accountNumber,bankNumber,id);
            Cache.getTheCache().put(result);
            return (IncomingAccountRuleProxi)PersistentProxi.createProxi(id, 229);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public IncomingAccountRuleProxi newDelayedIncomingAccountRule(long accountNumber,long bankNumber) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".IncAccRuleFacade.newDelayedIncAccRule(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            IncomingAccountRule result = new IncomingAccountRule(null,null,accountNumber,bankNumber,id);
            Cache.getTheCache().put(result);
            return (IncomingAccountRuleProxi)PersistentProxi.createProxi(id, 229);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public IncomingAccountRule getIncomingAccountRule(long IncomingAccountRuleId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".IncAccRuleFacade.getIncAccRule(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, IncomingAccountRuleId);
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
            IncomingAccountRule result = new IncomingAccountRule(subService,
                                                                 This,
                                                                 obj.getLong(6),
                                                                 obj.getLong(7),
                                                                 IncomingAccountRuleId);
            obj.close();
            callable.close();
            IncomingAccountRuleICProxi inCache = (IncomingAccountRuleICProxi)Cache.getTheCache().put(result);
            IncomingAccountRule objectInCache = (IncomingAccountRule)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void accountNumberSet(long IncomingAccountRuleId, long accountNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".IncAccRuleFacade.accntNmbrSet(?, ?); end;");
            callable.setLong(1, IncomingAccountRuleId);
            callable.setLong(2, accountNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void bankNumberSet(long IncomingAccountRuleId, long bankNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".IncAccRuleFacade.bnkNmbrSet(?, ?); end;");
            callable.setLong(1, IncomingAccountRuleId);
            callable.setLong(2, bankNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

