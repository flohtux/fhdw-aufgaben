package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateDebitGrantCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateDebitGrantCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateDebitGrantCommandProxi newCreateDebitGrantCommand(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtDbtGrntCMDFacade.newCrtDbtGrntCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateDebitGrantCommand result = new CreateDebitGrantCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateDebitGrantCommandProxi)PersistentProxi.createProxi(id, 198);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateDebitGrantCommandProxi newDelayedCreateDebitGrantCommand() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtDbtGrntCMDFacade.newDelayedCrtDbtGrntCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateDebitGrantCommand result = new CreateDebitGrantCommand(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateDebitGrantCommandProxi)PersistentProxi.createProxi(id, 198);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateDebitGrantCommand getCreateDebitGrantCommand(long CreateDebitGrantCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtDbtGrntCMDFacade.getCrtDbtGrntCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateDebitGrantCommandId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccount receiver = null;
            PersistentLimitType limit = null;
            Invoker invoker = null;
            PersistentAccount commandReceiver = null;
            PersistentCommonDate myCommonDate = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10283: {
                        receiver = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10284: {
                        limit = (PersistentLimitType)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10186: {
                        invoker = (Invoker)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10187: {
                        commandReceiver = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10188: {
                        myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            CreateDebitGrantCommand result = new CreateDebitGrantCommand(receiver, 
                                                                         limit, 
                                                                         invoker, 
                                                                         commandReceiver, 
                                                                         myCommonDate, 
                                                                         CreateDebitGrantCommandId);
            links.close();
            callable.close();
            CreateDebitGrantCommandICProxi inCache = (CreateDebitGrantCommandICProxi)Cache.getTheCache().put(result);
            CreateDebitGrantCommand objectInCache = (CreateDebitGrantCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtDbtGrntCMDFacade.getClass(?); end;");
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
    public void receiverSet(long CreateDebitGrantCommandId, PersistentAccount receiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.rcvrSet(?, ?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, receiverVal.getId());
            callable.setLong(3, receiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void limitSet(long CreateDebitGrantCommandId, PersistentLimitType limitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.lmtSet(?, ?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, limitVal.getId());
            callable.setLong(3, limitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateDebitGrantCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateDebitGrantCommandId, PersistentAccount commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateDebitGrantCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

