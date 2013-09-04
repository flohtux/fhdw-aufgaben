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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentRule This = null;
            long accountNumber = 0;
            long bankNumber = 0;
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
                    case 10298: {
                        accountNumber = links.getLong(5);
                        break;
                    }
                    case 10299: {
                        bankNumber = links.getLong(5);
                        break;
                    }
                }
            }
            IncomingAccountRule result = new IncomingAccountRule(subService, 
                                                                 This, 
                                                                 accountNumber, 
                                                                 bankNumber, 
                                                                 IncomingAccountRuleId);
            links.close();
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

