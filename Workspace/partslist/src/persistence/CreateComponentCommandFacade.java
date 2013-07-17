package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateComponentCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateComponentCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateComponentCommandProxi newCreateComponentCommand(String name,String componentType,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpnntCMDFacade.newCrtCmpnntCMD(?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setString(3, componentType);
            callable.setLong(4, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateComponentCommand result = new CreateComponentCommand(name,componentType,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateComponentCommandProxi)PersistentProxi.createProxi(id, 101);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateComponentCommandProxi newDelayedCreateComponentCommand(String name,String componentType) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpnntCMDFacade.newDelayedCrtCmpnntCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateComponentCommand result = new CreateComponentCommand(name,componentType,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateComponentCommandProxi)PersistentProxi.createProxi(id, 101);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateComponentCommand getCreateComponentCommand(long CreateComponentCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpnntCMDFacade.getCrtCmpnntCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateComponentCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Invoker invoker = null;
            if (obj.getLong(4) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentPartsListManager commandReceiver = null;
            if (obj.getLong(6) != 0)
                commandReceiver = (PersistentPartsListManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentComponent commandResult = null;
            if (obj.getLong(8) != 0)
                commandResult = (PersistentComponent)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            CreateComponentCommand result = new CreateComponentCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                       obj.getString(3) == null ? "" : obj.getString(3) /* In Oracle "" = null !!! */,
                                                                       invoker,
                                                                       commandReceiver,
                                                                       commandResult,
                                                                       myCommonDate,
                                                                       CreateComponentCommandId);
            obj.close();
            callable.close();
            CreateComponentCommandICProxi inCache = (CreateComponentCommandICProxi)Cache.getTheCache().put(result);
            CreateComponentCommand objectInCache = (CreateComponentCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtCmpnntCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateComponentCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpnntCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateComponentCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void componentTypeSet(long CreateComponentCommandId, String componentTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpnntCMDFacade.cmpnntTpSet(?, ?); end;");
            callable.setLong(1, CreateComponentCommandId);
            callable.setString(2, componentTypeVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateComponentCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpnntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateComponentCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateComponentCommandId, PersistentPartsListManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpnntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateComponentCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandResultSet(long CreateComponentCommandId, PersistentComponent commandResultVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpnntCMDFacade.cResultSet(?, ?, ?); end;");
            callable.setLong(1, CreateComponentCommandId);
            callable.setLong(2, commandResultVal.getId());
            callable.setLong(3, commandResultVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateComponentCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtCmpnntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateComponentCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

