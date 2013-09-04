package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class ExecuteCommandFacade{

	private String schemaName;
	private Connection con;

	public ExecuteCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ExecuteCommandProxi newExecuteCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctCMDFacade.newExctCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ExecuteCommand result = new ExecuteCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ExecuteCommandProxi)PersistentProxi.createProxi(id, 213);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ExecuteCommandProxi newDelayedExecuteCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctCMDFacade.newDelayedExctCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ExecuteCommand result = new ExecuteCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ExecuteCommandProxi)PersistentProxi.createProxi(id, 213);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ExecuteCommand getExecuteCommand(long ExecuteCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctCMDFacade.getExctCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ExecuteCommandId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            Invoker invoker = null;
            PersistentDebitTransferTransaction commandReceiver = null;
            PersistentDebitTransferTransaction commandResult = null;
            PersistentCommonDate myCommonDate = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10243: {
                        invoker = (Invoker)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10244: {
                        commandReceiver = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10297: {
                        commandResult = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10245: {
                        myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            ExecuteCommand result = new ExecuteCommand(invoker, 
                                                       commandReceiver, 
                                                       commandResult, 
                                                       myCommonDate, 
                                                       ExecuteCommandId);
            links.close();
            callable.close();
            ExecuteCommandICProxi inCache = (ExecuteCommandICProxi)Cache.getTheCache().put(result);
            ExecuteCommand objectInCache = (ExecuteCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctCMDFacade.getClass(?); end;");
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
    public void invokerSet(long ExecuteCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ExecuteCommandId, PersistentDebitTransferTransaction commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandResultSet(long ExecuteCommandId, PersistentDebitTransferTransaction commandResultVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctCMDFacade.cResultSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteCommandId);
            callable.setLong(2, commandResultVal.getId());
            callable.setLong(3, commandResultVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ExecuteCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

