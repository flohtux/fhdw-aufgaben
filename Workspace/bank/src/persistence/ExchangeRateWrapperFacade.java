package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class ExchangeRateWrapperFacade{

	private String schemaName;
	private Connection con;

	public ExchangeRateWrapperFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ExchangeRateWrapperProxi newExchangeRateWrapper(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ExchngRtWrpFacade.newExchngRtWrp(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ExchangeRateWrapper result = new ExchangeRateWrapper(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ExchangeRateWrapperProxi)PersistentProxi.createProxi(id, 273);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ExchangeRateWrapperProxi newDelayedExchangeRateWrapper() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ExchngRtWrpFacade.newDelayedExchngRtWrp(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ExchangeRateWrapper result = new ExchangeRateWrapper(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ExchangeRateWrapperProxi)PersistentProxi.createProxi(id, 273);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ExchangeRateWrapper getExchangeRateWrapper(long ExchangeRateWrapperId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ExchngRtWrpFacade.getExchngRtWrp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ExchangeRateWrapperId);
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
            PersistentExchangeRateWrapper This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentExchangeRateWrapper)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            ExchangeRateWrapper result = new ExchangeRateWrapper(amount,
                                                                 currency,
                                                                 subService,
                                                                 This,
                                                                 ExchangeRateWrapperId);
            obj.close();
            callable.close();
            ExchangeRateWrapperICProxi inCache = (ExchangeRateWrapperICProxi)Cache.getTheCache().put(result);
            ExchangeRateWrapper objectInCache = (ExchangeRateWrapper)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ExchngRtWrpFacade.getClass(?); end;");
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
    public void amountSet(long ExchangeRateWrapperId, PersistentAmount amountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExchngRtWrpFacade.amntSet(?, ?, ?); end;");
            callable.setLong(1, ExchangeRateWrapperId);
            callable.setLong(2, amountVal.getId());
            callable.setLong(3, amountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void currencySet(long ExchangeRateWrapperId, PersistentCurrency currencyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExchngRtWrpFacade.crrncSet(?, ?, ?); end;");
            callable.setLong(1, ExchangeRateWrapperId);
            callable.setLong(2, currencyVal.getId());
            callable.setLong(3, currencyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long ExchangeRateWrapperId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExchngRtWrpFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, ExchangeRateWrapperId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ExchangeRateWrapperId, PersistentExchangeRateWrapper ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExchngRtWrpFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ExchangeRateWrapperId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

