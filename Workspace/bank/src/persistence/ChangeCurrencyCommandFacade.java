package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class ChangeCurrencyCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeCurrencyCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ChangeCurrencyCommandProxi newChangeCurrencyCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngCrrncCMDFacade.newChngCrrncCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeCurrencyCommand result = new ChangeCurrencyCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ChangeCurrencyCommandProxi)PersistentProxi.createProxi(id, 219);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeCurrencyCommandProxi newDelayedChangeCurrencyCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngCrrncCMDFacade.newDelayedChngCrrncCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeCurrencyCommand result = new ChangeCurrencyCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ChangeCurrencyCommandProxi)PersistentProxi.createProxi(id, 219);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeCurrencyCommand getChangeCurrencyCommand(long ChangeCurrencyCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngCrrncCMDFacade.getChngCrrncCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ChangeCurrencyCommandId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentDebitTransfer trans = null;
            PersistentCurrency currency = null;
            Invoker invoker = null;
            PersistentAccount commandReceiver = null;
            PersistentCommonDate myCommonDate = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10262: {
                        trans = (PersistentDebitTransfer)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10263: {
                        currency = (PersistentCurrency)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10264: {
                        invoker = (Invoker)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10265: {
                        commandReceiver = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10266: {
                        myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            ChangeCurrencyCommand result = new ChangeCurrencyCommand(trans, 
                                                                     currency, 
                                                                     invoker, 
                                                                     commandReceiver, 
                                                                     myCommonDate, 
                                                                     ChangeCurrencyCommandId);
            links.close();
            callable.close();
            ChangeCurrencyCommandICProxi inCache = (ChangeCurrencyCommandICProxi)Cache.getTheCache().put(result);
            ChangeCurrencyCommand objectInCache = (ChangeCurrencyCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngCrrncCMDFacade.getClass(?); end;");
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
    public void transSet(long ChangeCurrencyCommandId, PersistentDebitTransfer transVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngCrrncCMDFacade.trnsSet(?, ?, ?); end;");
            callable.setLong(1, ChangeCurrencyCommandId);
            callable.setLong(2, transVal.getId());
            callable.setLong(3, transVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void currencySet(long ChangeCurrencyCommandId, PersistentCurrency currencyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngCrrncCMDFacade.crrncSet(?, ?, ?); end;");
            callable.setLong(1, ChangeCurrencyCommandId);
            callable.setLong(2, currencyVal.getId());
            callable.setLong(3, currencyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeCurrencyCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngCrrncCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeCurrencyCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeCurrencyCommandId, PersistentAccount commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngCrrncCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeCurrencyCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeCurrencyCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngCrrncCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeCurrencyCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

