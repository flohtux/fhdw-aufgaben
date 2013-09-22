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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAmount amount = null;
            PersistentCurrency currency = null;
            SubjInterface subService = null;
            PersistentExchangeRateWrapper This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10410: {
                        amount = (PersistentAmount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10411: {
                        currency = (PersistentCurrency)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10412: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10413: {
                        This = (PersistentExchangeRateWrapper)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            ExchangeRateWrapper result = new ExchangeRateWrapper(amount, 
                                                                 currency, 
                                                                 subService, 
                                                                 This, 
                                                                 ExchangeRateWrapperId);
            links.close();
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

