package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountServiceFacade{

	private String schemaName;
	private Connection con;

	public AccountServiceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountServiceProxi newAccountService(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcFacade.newAccntSrvc(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountService result = new AccountService(null,null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceProxi)PersistentProxi.createProxi(id, -130);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceProxi newDelayedAccountService() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcFacade.newDelayedAccntSrvc(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountService result = new AccountService(null,null,null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceProxi)PersistentProxi.createProxi(id, -130);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountService getAccountService(long AccountServiceId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcFacade.getAccntSrvc(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountServiceId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentService This = null;
            PersistentAccount account = null;
            PersistentEventWrapper eventhandle = null;
            PersistentAccountServiceSuccessful successful = null;
            PersistentAccountServiceNotExecuted notExecuted = null;
            PersistentAccountServiceTemplate template = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10001: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10002: {
                        This = (PersistentService)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10058: {
                        account = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10288: {
                        eventhandle = (PersistentEventWrapper)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10192: {
                        successful = (PersistentAccountServiceSuccessful)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10193: {
                        notExecuted = (PersistentAccountServiceNotExecuted)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10230: {
                        template = (PersistentAccountServiceTemplate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            AccountService result = new AccountService(subService, 
                                                       This, 
                                                       account, 
                                                       eventhandle, 
                                                       successful, 
                                                       notExecuted, 
                                                       template, 
                                                       AccountServiceId);
            links.close();
            callable.close();
            AccountServiceICProxi inCache = (AccountServiceICProxi)Cache.getTheCache().put(result);
            AccountService objectInCache = (AccountService)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void accountSet(long AccountServiceId, PersistentAccount accountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcFacade.accntSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceId);
            callable.setLong(2, accountVal.getId());
            callable.setLong(3, accountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void eventhandleSet(long AccountServiceId, PersistentEventWrapper eventhandleVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcFacade.evnthndlSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceId);
            callable.setLong(2, eventhandleVal.getId());
            callable.setLong(3, eventhandleVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void successfulSet(long AccountServiceId, PersistentAccountServiceSuccessful successfulVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcFacade.sccssflSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceId);
            callable.setLong(2, successfulVal.getId());
            callable.setLong(3, successfulVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void notExecutedSet(long AccountServiceId, PersistentAccountServiceNotExecuted notExecutedVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcFacade.ntExctdSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceId);
            callable.setLong(2, notExecutedVal.getId());
            callable.setLong(3, notExecutedVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void templateSet(long AccountServiceId, PersistentAccountServiceTemplate templateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcFacade.tmpltSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceId);
            callable.setLong(2, templateVal.getId());
            callable.setLong(3, templateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AccountServiceSearchList inverseGetAccount(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcFacade.iGetAccnt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AccountServiceSearchList result = new AccountServiceSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentAccountService)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentAccountService)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public AccountServiceSearchList inverseGetEventhandle(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcFacade.iGetEvnthndl(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            AccountServiceSearchList result = new AccountServiceSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentAccountService)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentAccountService)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

