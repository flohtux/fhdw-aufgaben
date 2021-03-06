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
            AccountService result = new AccountService(null,null,null,null,null,null,null,null,id);
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
            AccountService result = new AccountService(null,null,null,null,null,null,null,null,id);
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
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentService This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentService)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAccount account = null;
            if (obj.getLong(6) != 0)
                account = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentEventWrapper eventhandle = null;
            if (obj.getLong(8) != 0)
                eventhandle = (PersistentEventWrapper)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentAccountServiceSuccessful successful = null;
            if (obj.getLong(10) != 0)
                successful = (PersistentAccountServiceSuccessful)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            PersistentAccountServiceNotExecuted notExecuted = null;
            if (obj.getLong(12) != 0)
                notExecuted = (PersistentAccountServiceNotExecuted)PersistentProxi.createProxi(obj.getLong(12), obj.getLong(13));
            PersistentAccountServiceTemplate template = null;
            if (obj.getLong(14) != 0)
                template = (PersistentAccountServiceTemplate)PersistentProxi.createProxi(obj.getLong(14), obj.getLong(15));
            PersistentAccountServiceBankFees bankFees = null;
            if (obj.getLong(16) != 0)
                bankFees = (PersistentAccountServiceBankFees)PersistentProxi.createProxi(obj.getLong(16), obj.getLong(17));
            AccountService result = new AccountService(subService,
                                                       This,
                                                       account,
                                                       eventhandle,
                                                       successful,
                                                       notExecuted,
                                                       template,
                                                       bankFees,
                                                       AccountServiceId);
            obj.close();
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
    public void bankFeesSet(long AccountServiceId, PersistentAccountServiceBankFees bankFeesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcFacade.bnkFsSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceId);
            callable.setLong(2, bankFeesVal.getId());
            callable.setLong(3, bankFeesVal.getClassId());
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

