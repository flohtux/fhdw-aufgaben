package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class ChangeReceiverBankCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeReceiverBankCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ChangeReceiverBankCommandProxi newChangeReceiverBankCommand(long receiverBankNumber,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngRcvrBnkCMDFacade.newChngRcvrBnkCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, receiverBankNumber);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeReceiverBankCommand result = new ChangeReceiverBankCommand(null,receiverBankNumber,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ChangeReceiverBankCommandProxi)PersistentProxi.createProxi(id, 215);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeReceiverBankCommandProxi newDelayedChangeReceiverBankCommand(long receiverBankNumber) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngRcvrBnkCMDFacade.newDelayedChngRcvrBnkCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeReceiverBankCommand result = new ChangeReceiverBankCommand(null,receiverBankNumber,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ChangeReceiverBankCommandProxi)PersistentProxi.createProxi(id, 215);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeReceiverBankCommand getChangeReceiverBankCommand(long ChangeReceiverBankCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngRcvrBnkCMDFacade.getChngRcvrBnkCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ChangeReceiverBankCommandId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentDebitTransfer trans = null;
            long receiverBankNumber = 0;
            Invoker invoker = null;
            PersistentAccount commandReceiver = null;
            PersistentCommonDate myCommonDate = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10247: {
                        trans = (PersistentDebitTransfer)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10248: {
                        receiverBankNumber = links.getLong(5);
                        break;
                    }
                    case 10249: {
                        invoker = (Invoker)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10250: {
                        commandReceiver = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10251: {
                        myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            ChangeReceiverBankCommand result = new ChangeReceiverBankCommand(trans, 
                                                                             receiverBankNumber, 
                                                                             invoker, 
                                                                             commandReceiver, 
                                                                             myCommonDate, 
                                                                             ChangeReceiverBankCommandId);
            links.close();
            callable.close();
            ChangeReceiverBankCommandICProxi inCache = (ChangeReceiverBankCommandICProxi)Cache.getTheCache().put(result);
            ChangeReceiverBankCommand objectInCache = (ChangeReceiverBankCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngRcvrBnkCMDFacade.getClass(?); end;");
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
    public void transSet(long ChangeReceiverBankCommandId, PersistentDebitTransfer transVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngRcvrBnkCMDFacade.trnsSet(?, ?, ?); end;");
            callable.setLong(1, ChangeReceiverBankCommandId);
            callable.setLong(2, transVal.getId());
            callable.setLong(3, transVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void receiverBankNumberSet(long ChangeReceiverBankCommandId, long receiverBankNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngRcvrBnkCMDFacade.rcvrBnkNmbrSet(?, ?); end;");
            callable.setLong(1, ChangeReceiverBankCommandId);
            callable.setLong(2, receiverBankNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeReceiverBankCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngRcvrBnkCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeReceiverBankCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeReceiverBankCommandId, PersistentAccount commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngRcvrBnkCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeReceiverBankCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeReceiverBankCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngRcvrBnkCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeReceiverBankCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

