package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class ExecuteTransferCommandFacade{

	private String schemaName;
	private Connection con;

	public ExecuteTransferCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ExecuteTransferCommandProxi newExecuteTransferCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctTrnsfrCMDFacade.newExctTrnsfrCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ExecuteTransferCommand result = new ExecuteTransferCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ExecuteTransferCommandProxi)PersistentProxi.createProxi(id, 184);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ExecuteTransferCommandProxi newDelayedExecuteTransferCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctTrnsfrCMDFacade.newDelayedExctTrnsfrCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ExecuteTransferCommand result = new ExecuteTransferCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ExecuteTransferCommandProxi)PersistentProxi.createProxi(id, 184);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ExecuteTransferCommand getExecuteTransferCommand(long ExecuteTransferCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctTrnsfrCMDFacade.getExctTrnsfrCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ExecuteTransferCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentDebitTransfer debitTransfer = null;
            if (obj.getLong(2) != 0)
                debitTransfer = (PersistentDebitTransfer)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAccountService commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentAccountService)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            ExecuteTransferCommand result = new ExecuteTransferCommand(debitTransfer,
                                                                       invoker,
                                                                       commandReceiver,
                                                                       myCommonDate,
                                                                       ExecuteTransferCommandId);
            obj.close();
            callable.close();
            ExecuteTransferCommandICProxi inCache = (ExecuteTransferCommandICProxi)Cache.getTheCache().put(result);
            ExecuteTransferCommand objectInCache = (ExecuteTransferCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctTrnsfrCMDFacade.getClass(?); end;");
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
    public void debitTransferSet(long ExecuteTransferCommandId, PersistentDebitTransfer debitTransferVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctTrnsfrCMDFacade.dbtTrnsfrSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteTransferCommandId);
            callable.setLong(2, debitTransferVal.getId());
            callable.setLong(3, debitTransferVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ExecuteTransferCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctTrnsfrCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteTransferCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ExecuteTransferCommandId, PersistentAccountService commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctTrnsfrCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteTransferCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ExecuteTransferCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctTrnsfrCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteTransferCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

