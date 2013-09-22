package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class ChangeMoneyCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeMoneyCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ChangeMoneyCommandProxi newChangeMoneyCommand(common.Fraction newAmount,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngMnCMDFacade.newChngMnCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, newAmount.toString());
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeMoneyCommand result = new ChangeMoneyCommand(null,newAmount,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ChangeMoneyCommandProxi)PersistentProxi.createProxi(id, 218);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeMoneyCommandProxi newDelayedChangeMoneyCommand(common.Fraction newAmount) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngMnCMDFacade.newDelayedChngMnCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeMoneyCommand result = new ChangeMoneyCommand(null,newAmount,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ChangeMoneyCommandProxi)PersistentProxi.createProxi(id, 218);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeMoneyCommand getChangeMoneyCommand(long ChangeMoneyCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngMnCMDFacade.getChngMnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ChangeMoneyCommandId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentDebitTransfer trans = null;
            common.Fraction newAmount = common.Fraction.Null;
            Invoker invoker = null;
            PersistentAccount commandReceiver = null;
            PersistentCommonDate myCommonDate = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10257: {
                        trans = (PersistentDebitTransfer)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10258: {
                        newAmount = common.Fraction.parse(links.getString(10));
                        break;
                    }
                    case 10259: {
                        invoker = (Invoker)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10260: {
                        commandReceiver = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10261: {
                        myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            ChangeMoneyCommand result = new ChangeMoneyCommand(trans, 
                                                               newAmount, 
                                                               invoker, 
                                                               commandReceiver, 
                                                               myCommonDate, 
                                                               ChangeMoneyCommandId);
            links.close();
            callable.close();
            ChangeMoneyCommandICProxi inCache = (ChangeMoneyCommandICProxi)Cache.getTheCache().put(result);
            ChangeMoneyCommand objectInCache = (ChangeMoneyCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngMnCMDFacade.getClass(?); end;");
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
    public void transSet(long ChangeMoneyCommandId, PersistentDebitTransfer transVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngMnCMDFacade.trnsSet(?, ?, ?); end;");
            callable.setLong(1, ChangeMoneyCommandId);
            callable.setLong(2, transVal.getId());
            callable.setLong(3, transVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void newAmountSet(long ChangeMoneyCommandId, common.Fraction newAmountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngMnCMDFacade.nwAmntSet(?, ?); end;");
            callable.setLong(1, ChangeMoneyCommandId);
            callable.setString(2, newAmountVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeMoneyCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngMnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeMoneyCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeMoneyCommandId, PersistentAccount commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngMnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeMoneyCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeMoneyCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngMnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeMoneyCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

