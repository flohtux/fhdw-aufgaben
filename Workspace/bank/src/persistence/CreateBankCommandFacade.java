package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateBankCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateBankCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateBankCommandProxi newCreateBankCommand(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtBnkCMDFacade.newCrtBnkCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateBankCommand result = new CreateBankCommand(name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateBankCommandProxi)PersistentProxi.createProxi(id, 118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateBankCommandProxi newDelayedCreateBankCommand(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtBnkCMDFacade.newDelayedCrtBnkCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateBankCommand result = new CreateBankCommand(name,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateBankCommandProxi)PersistentProxi.createProxi(id, 118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateBankCommand getCreateBankCommand(long CreateBankCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtBnkCMDFacade.getCrtBnkCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateBankCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAdministrator administrator = null;
            if (obj.getLong(3) != 0)
                administrator = (PersistentAdministrator)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            Invoker invoker = null;
            if (obj.getLong(5) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentBankCreator commandReceiver = null;
            if (obj.getLong(7) != 0)
                commandReceiver = (PersistentBankCreator)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentBank commandResult = null;
            if (obj.getLong(9) != 0)
                commandResult = (PersistentBank)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            CreateBankCommand result = new CreateBankCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                             administrator,
                                                             invoker,
                                                             commandReceiver,
                                                             commandResult,
                                                             myCommonDate,
                                                             CreateBankCommandId);
            obj.close();
            callable.close();
            CreateBankCommandICProxi inCache = (CreateBankCommandICProxi)Cache.getTheCache().put(result);
            CreateBankCommand objectInCache = (CreateBankCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtBnkCMDFacade.getClass(?); end;");
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
    public void nameSet(long CreateBankCommandId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtBnkCMDFacade.nmSet(?, ?); end;");
            callable.setLong(1, CreateBankCommandId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void administratorSet(long CreateBankCommandId, PersistentAdministrator administratorVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtBnkCMDFacade.admnstrtrSet(?, ?, ?); end;");
            callable.setLong(1, CreateBankCommandId);
            callable.setLong(2, administratorVal.getId());
            callable.setLong(3, administratorVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateBankCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtBnkCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateBankCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateBankCommandId, PersistentBankCreator commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtBnkCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateBankCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandResultSet(long CreateBankCommandId, PersistentBank commandResultVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtBnkCMDFacade.cResultSet(?, ?, ?); end;");
            callable.setLong(1, CreateBankCommandId);
            callable.setLong(2, commandResultVal.getId());
            callable.setLong(3, commandResultVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateBankCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtBnkCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateBankCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

