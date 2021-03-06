package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CurrencyManagerFacade{

	private String schemaName;
	private Connection con;

	public CurrencyManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CurrencyManagerProxi getTheCurrencyManager() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrrncMngrFacade.getTheCrrncMngr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (CurrencyManagerProxi)PersistentProxi.createProxi(id, 179);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CurrencyManager getCurrencyManager(long CurrencyManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrrncMngrFacade.getCrrncMngr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CurrencyManagerId);
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
            PersistentCurrencyManager This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentCurrencyManager)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            CurrencyManager result = new CurrencyManager(subService,
                                                         This,
                                                         CurrencyManagerId);
            obj.close();
            callable.close();
            CurrencyManagerICProxi inCache = (CurrencyManagerICProxi)Cache.getTheCache().put(result);
            CurrencyManager objectInCache = (CurrencyManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrrncMngrFacade.getClass(?); end;");
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
    public long exchangeRatesGUIAdd(long CurrencyManagerId, PersistentExchangeRateWrapper exchangeRatesGUIVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrrncMngrFacade.xchngRtGUIAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CurrencyManagerId);
            callable.setLong(3, exchangeRatesGUIVal.getId());
            callable.setLong(4, exchangeRatesGUIVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void exchangeRatesGUIRem(long exchangeRatesGUIId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrrncMngrFacade.xchngRtGUIRem(?); end;");
            callable.setLong(1, exchangeRatesGUIId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ExchangeRateWrapperList exchangeRatesGUIGet(long CurrencyManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrrncMngrFacade.xchngRtGUIGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CurrencyManagerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ExchangeRateWrapperList result = new ExchangeRateWrapperList();
            while (list.next()) {
                result.add((PersistentExchangeRateWrapper)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long exchangeRatesAdd(long CurrencyManagerId, PersistentCurrency indxxVal, PersistentAmount exchangeRatesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrrncMngrFacade.exchngRtsAdd(?, ?, ?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CurrencyManagerId);
            callable.setLong(3, indxxVal.getId());
            callable.setLong(4, indxxVal.getClassId());
            callable.setLong(5, exchangeRatesVal.getId());
            callable.setLong(6, exchangeRatesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void exchangeRatesRem(long CurrencyManagerId, PersistentCurrency indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrrncMngrFacade.exchngRtsRem(?,?,?); end;");
            callable.setLong(1, CurrencyManagerId);
            callable.setLong(2, indxxVal.getId());
            callable.setLong(3, indxxVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public PersistentAmount exchangeRatesGet(long CurrencyManagerId, PersistentCurrency indxxVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrrncMngrFacade.exchngRtsGet(?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CurrencyManagerId);
            callable.setLong(3, indxxVal.getId());
            callable.setLong(4, indxxVal.getClassId());
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAmount result = null;
            if (list.next()) result = (PersistentAmount)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3));
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AmountSearchList exchangeRatesGetValues(long CurrencyManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrrncMngrFacade.exchngRtsGetValues(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CurrencyManagerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AmountSearchList result = new AmountSearchList();
            while (list.next()) {
                result.add((PersistentAmount)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long currencyStockAdd(long CurrencyManagerId, PersistentMoney currencyStockVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrrncMngrFacade.crrncStckAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CurrencyManagerId);
            callable.setLong(3, currencyStockVal.getId());
            callable.setLong(4, currencyStockVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void currencyStockRem(long currencyStockId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrrncMngrFacade.crrncStckRem(?); end;");
            callable.setLong(1, currencyStockId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public MoneyList currencyStockGet(long CurrencyManagerId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrrncMngrFacade.crrncStckGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CurrencyManagerId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            MoneyList result = new MoneyList();
            while (list.next()) {
                result.add((PersistentMoney)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long CurrencyManagerId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrrncMngrFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, CurrencyManagerId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long CurrencyManagerId, PersistentCurrencyManager ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrrncMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, CurrencyManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

