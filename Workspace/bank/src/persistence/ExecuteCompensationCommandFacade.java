package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class ExecuteCompensationCommandFacade{

	private String schemaName;
	private Connection con;

	public ExecuteCompensationCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ExecuteCompensationCommandProxi newExecuteCompensationCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctCmpnstnCMDFacade.newExctCmpnstnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ExecuteCompensationCommand result = new ExecuteCompensationCommand(null,null,null,id);
            Cache.getTheCache().put(result);
            return (ExecuteCompensationCommandProxi)PersistentProxi.createProxi(id, 255);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ExecuteCompensationCommandProxi newDelayedExecuteCompensationCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctCmpnstnCMDFacade.newDelayedExctCmpnstnCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ExecuteCompensationCommand result = new ExecuteCompensationCommand(null,null,null,id);
            Cache.getTheCache().put(result);
            return (ExecuteCompensationCommandProxi)PersistentProxi.createProxi(id, 255);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ExecuteCompensationCommand getExecuteCompensationCommand(long ExecuteCompensationCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctCmpnstnCMDFacade.getExctCmpnstnCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ExecuteCompensationCommandId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            Invoker invoker = null;
            PersistentCompensation commandReceiver = null;
            PersistentCommonDate myCommonDate = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10362: {
                        invoker = (Invoker)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10363: {
                        commandReceiver = (PersistentCompensation)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10364: {
                        myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            ExecuteCompensationCommand result = new ExecuteCompensationCommand(invoker, 
                                                                               commandReceiver, 
                                                                               myCommonDate, 
                                                                               ExecuteCompensationCommandId);
            links.close();
            callable.close();
            ExecuteCompensationCommandICProxi inCache = (ExecuteCompensationCommandICProxi)Cache.getTheCache().put(result);
            ExecuteCompensationCommand objectInCache = (ExecuteCompensationCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ExctCmpnstnCMDFacade.getClass(?); end;");
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
    public void invokerSet(long ExecuteCompensationCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctCmpnstnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteCompensationCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ExecuteCompensationCommandId, PersistentCompensation commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctCmpnstnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteCompensationCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ExecuteCompensationCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ExctCmpnstnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ExecuteCompensationCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

