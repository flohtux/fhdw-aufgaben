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
            AccountService result = new AccountService(null,null,null,null,null,id);
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
            AccountService result = new AccountService(null,null,null,null,null,id);
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
            PersistentAccountServiceSuccessfullStates successfullStates = null;
            if (obj.getLong(8) != 0)
                successfullStates = (PersistentAccountServiceSuccessfullStates)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentAccountServiceNotSuccessfullStates notSuccessfullStates = null;
            if (obj.getLong(10) != 0)
                notSuccessfullStates = (PersistentAccountServiceNotSuccessfullStates)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            AccountService result = new AccountService(subService,
                                                       This,
                                                       account,
                                                       successfullStates,
                                                       notSuccessfullStates,
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
    public void successfullStatesSet(long AccountServiceId, PersistentAccountServiceSuccessfullStates successfullStatesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcFacade.sucstatesSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceId);
            callable.setLong(2, successfullStatesVal.getId());
            callable.setLong(3, successfullStatesVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void notSuccessfullStatesSet(long AccountServiceId, PersistentAccountServiceNotSuccessfullStates notSuccessfullStatesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcFacade.ntsucstatesSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceId);
            callable.setLong(2, notSuccessfullStatesVal.getId());
            callable.setLong(3, notSuccessfullStatesVal.getClassId());
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

}

