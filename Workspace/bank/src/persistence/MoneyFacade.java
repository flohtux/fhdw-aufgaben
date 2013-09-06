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
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAmount amount = null;
            if (obj.getLong(2) != 0)
                amount = (PersistentAmount)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentCurrency currency = null;
            if (obj.getLong(4) != 0)
                currency = (PersistentCurrency)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentMoney This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            Money result = new Money(amount,
                                     currency,
                                     subService,
                                     This,
                                     MoneyId);
            obj.close();
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

