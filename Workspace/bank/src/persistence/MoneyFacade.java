package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MoneyFacade{

	private String schemaName;
	private Connection con;

	public MoneyFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MoneyProxi newMoney(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MnFacade.newMn(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Money result = new Money(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MoneyProxi)PersistentProxi.createProxi(id, 148);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MoneyProxi newDelayedMoney() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MnFacade.newDelayedMn(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Money result = new Money(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MoneyProxi)PersistentProxi.createProxi(id, 148);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Money getMoney(long MoneyId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MnFacade.getMn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MoneyId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAmount amount = null;
            PersistentCurrency currency = null;
            SubjInterface subService = null;
            PersistentMoney This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10106: {
                        amount = (PersistentAmount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10079: {
                        currency = (PersistentCurrency)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10080: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10081: {
                        This = (PersistentMoney)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            Money result = new Money(amount, 
                                     currency, 
                                     subService, 
                                     This, 
                                     MoneyId);
            links.close();
            callable.close();
            MoneyICProxi inCache = (MoneyICProxi)Cache.getTheCache().put(result);
            Money objectInCache = (Money)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MnFacade.getClass(?); end;");
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
    public void amountSet(long MoneyId, PersistentAmount amountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MnFacade.amntSet(?, ?, ?); end;");
            callable.setLong(1, MoneyId);
            callable.setLong(2, amountVal.getId());
            callable.setLong(3, amountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void currencySet(long MoneyId, PersistentCurrency currencyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MnFacade.crrncSet(?, ?, ?); end;");
            callable.setLong(1, MoneyId);
            callable.setLong(2, currencyVal.getId());
            callable.setLong(3, currencyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long MoneyId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MnFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, MoneyId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long MoneyId, PersistentMoney ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MnFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, MoneyId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

