package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompensationDeclinedCommandFacade{

	private String schemaName;
	private Connection con;

	public CompensationDeclinedCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompensationDeclinedCommandProxi newCompensationDeclinedCommand(String reason,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpDeclndCMDFacade.newCmpDeclndCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, reason);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationDeclinedCommand result = new CompensationDeclinedCommand(null,reason,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationDeclinedCommandProxi)PersistentProxi.createProxi(id, 268);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationDeclinedCommandProxi newDelayedCompensationDeclinedCommand(String reason) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpDeclndCMDFacade.newDelayedCmpDeclndCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationDeclinedCommand result = new CompensationDeclinedCommand(null,reason,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationDeclinedCommandProxi)PersistentProxi.createProxi(id, 268);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationDeclinedCommand getCompensationDeclinedCommand(long CompensationDeclinedCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpDeclndCMDFacade.getCmpDeclndCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensationDeclinedCommandId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentCompensation compensation = null;
            String reason = "";
            Invoker invoker = null;
            PersistentAccount commandReceiver = null;
            PersistentCommonDate myCommonDate = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10395: {
                        compensation = (PersistentCompensation)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10399: {
                        reason = links.getString(6);
                        if(reason == null)reason = "";
                        break;
                    }
                    case 10396: {
                        invoker = (Invoker)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10397: {
                        commandReceiver = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10398: {
                        myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            CompensationDeclinedCommand result = new CompensationDeclinedCommand(compensation, 
                                                                                 reason, 
                                                                                 invoker, 
                                                                                 commandReceiver, 
                                                                                 myCommonDate, 
                                                                                 CompensationDeclinedCommandId);
            links.close();
            callable.close();
            CompensationDeclinedCommandICProxi inCache = (CompensationDeclinedCommandICProxi)Cache.getTheCache().put(result);
            CompensationDeclinedCommand objectInCache = (CompensationDeclinedCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpDeclndCMDFacade.getClass(?); end;");
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
    public void compensationSet(long CompensationDeclinedCommandId, PersistentCompensation compensationVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpDeclndCMDFacade.cmpnstnSet(?, ?, ?); end;");
            callable.setLong(1, CompensationDeclinedCommandId);
            callable.setLong(2, compensationVal.getId());
            callable.setLong(3, compensationVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void reasonSet(long CompensationDeclinedCommandId, String reasonVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpDeclndCMDFacade.rsnSet(?, ?); end;");
            callable.setLong(1, CompensationDeclinedCommandId);
            callable.setString(2, reasonVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CompensationDeclinedCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpDeclndCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CompensationDeclinedCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CompensationDeclinedCommandId, PersistentAccount commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpDeclndCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CompensationDeclinedCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CompensationDeclinedCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpDeclndCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CompensationDeclinedCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

