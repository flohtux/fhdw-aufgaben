package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class UseTemplateCommandFacade{

	private String schemaName;
	private Connection con;

	public UseTemplateCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public UseTemplateCommandProxi newUseTemplateCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UsTmpltCMDFacade.newUsTmpltCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            UseTemplateCommand result = new UseTemplateCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (UseTemplateCommandProxi)PersistentProxi.createProxi(id, 209);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public UseTemplateCommandProxi newDelayedUseTemplateCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".UsTmpltCMDFacade.newDelayedUsTmpltCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            UseTemplateCommand result = new UseTemplateCommand(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (UseTemplateCommandProxi)PersistentProxi.createProxi(id, 209);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public UseTemplateCommand getUseTemplateCommand(long UseTemplateCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UsTmpltCMDFacade.getUsTmpltCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, UseTemplateCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentTransfer debitTransfer = null;
            if (obj.getLong(2) != 0)
                debitTransfer = (PersistentTransfer)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAccountService commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentAccountService)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(8) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            UseTemplateCommand result = new UseTemplateCommand(debitTransfer,
                                                               invoker,
                                                               commandReceiver,
                                                               myCommonDate,
                                                               UseTemplateCommandId);
            obj.close();
            callable.close();
            UseTemplateCommandICProxi inCache = (UseTemplateCommandICProxi)Cache.getTheCache().put(result);
            UseTemplateCommand objectInCache = (UseTemplateCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".UsTmpltCMDFacade.getClass(?); end;");
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
    public void debitTransferSet(long UseTemplateCommandId, PersistentTransfer debitTransferVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UsTmpltCMDFacade.dbtTrnsfrSet(?, ?, ?); end;");
            callable.setLong(1, UseTemplateCommandId);
            callable.setLong(2, debitTransferVal.getId());
            callable.setLong(3, debitTransferVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long UseTemplateCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UsTmpltCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, UseTemplateCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long UseTemplateCommandId, PersistentAccountService commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UsTmpltCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, UseTemplateCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long UseTemplateCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".UsTmpltCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, UseTemplateCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

