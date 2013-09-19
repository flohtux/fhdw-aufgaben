package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class ChangeReceiverAccountCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeReceiverAccountCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ChangeReceiverAccountCommandProxi newChangeReceiverAccountCommand(long receiverAccountNumber,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngRcvAccCMDFacade.newChngRcvAccCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, receiverAccountNumber);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeReceiverAccountCommand result = new ChangeReceiverAccountCommand(null,receiverAccountNumber,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ChangeReceiverAccountCommandProxi)PersistentProxi.createProxi(id, 217);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeReceiverAccountCommandProxi newDelayedChangeReceiverAccountCommand(long receiverAccountNumber) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngRcvAccCMDFacade.newDelayedChngRcvAccCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeReceiverAccountCommand result = new ChangeReceiverAccountCommand(null,receiverAccountNumber,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ChangeReceiverAccountCommandProxi)PersistentProxi.createProxi(id, 217);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeReceiverAccountCommand getChangeReceiverAccountCommand(long ChangeReceiverAccountCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngRcvAccCMDFacade.getChngRcvAccCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ChangeReceiverAccountCommandId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentDebitTransfer trans = null;
            long receiverAccountNumber = 0;
            Invoker invoker = null;
            PersistentAccount commandReceiver = null;
            PersistentCommonDate myCommonDate = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10252: {
                        trans = (PersistentDebitTransfer)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10253: {
                        receiverAccountNumber = links.getLong(5);
                        break;
                    }
                    case 10254: {
                        invoker = (Invoker)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10255: {
                        commandReceiver = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10256: {
                        myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            ChangeReceiverAccountCommand result = new ChangeReceiverAccountCommand(trans, 
                                                                                   receiverAccountNumber, 
                                                                                   invoker, 
                                                                                   commandReceiver, 
                                                                                   myCommonDate, 
                                                                                   ChangeReceiverAccountCommandId);
            links.close();
            callable.close();
            ChangeReceiverAccountCommandICProxi inCache = (ChangeReceiverAccountCommandICProxi)Cache.getTheCache().put(result);
            ChangeReceiverAccountCommand objectInCache = (ChangeReceiverAccountCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngRcvAccCMDFacade.getClass(?); end;");
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
    public void transSet(long ChangeReceiverAccountCommandId, PersistentDebitTransfer transVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngRcvAccCMDFacade.trnsSet(?, ?, ?); end;");
            callable.setLong(1, ChangeReceiverAccountCommandId);
            callable.setLong(2, transVal.getId());
            callable.setLong(3, transVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void receiverAccountNumberSet(long ChangeReceiverAccountCommandId, long receiverAccountNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngRcvAccCMDFacade.recAccNrSet(?, ?); end;");
            callable.setLong(1, ChangeReceiverAccountCommandId);
            callable.setLong(2, receiverAccountNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeReceiverAccountCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngRcvAccCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeReceiverAccountCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeReceiverAccountCommandId, PersistentAccount commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngRcvAccCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeReceiverAccountCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeReceiverAccountCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngRcvAccCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeReceiverAccountCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

