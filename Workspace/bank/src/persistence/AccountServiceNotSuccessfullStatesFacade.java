package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountServiceNotSuccessfullStatesFacade{

	private String schemaName;
	private Connection con;

	public AccountServiceNotSuccessfullStatesFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountServiceNotSuccessfullStatesProxi newAccountServiceNotSuccessfullStates(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcNtsucstatesFacade.newAccntSrvcNtsucstates(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceNotSuccessfullStates result = new AccountServiceNotSuccessfullStates(null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceNotSuccessfullStatesProxi)PersistentProxi.createProxi(id, 195);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceNotSuccessfullStatesProxi newDelayedAccountServiceNotSuccessfullStates() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcNtsucstatesFacade.newDelayedAccntSrvcNtsucstates(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceNotSuccessfullStates result = new AccountServiceNotSuccessfullStates(null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceNotSuccessfullStatesProxi)PersistentProxi.createProxi(id, 195);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceNotSuccessfullStates getAccountServiceNotSuccessfullStates(long AccountServiceNotSuccessfullStatesId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcNtsucstatesFacade.getAccntSrvcNtsucstates(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountServiceNotSuccessfullStatesId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAccountService observer = null;
            if (obj.getLong(2) != 0)
                observer = (PersistentAccountService)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAccountServiceNotSuccessfullStates This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentAccountServiceNotSuccessfullStates)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            AccountServiceNotSuccessfullStates result = new AccountServiceNotSuccessfullStates(observer,
                                                                                               This,
                                                                                               AccountServiceNotSuccessfullStatesId);
            obj.close();
            callable.close();
            AccountServiceNotSuccessfullStatesICProxi inCache = (AccountServiceNotSuccessfullStatesICProxi)Cache.getTheCache().put(result);
            AccountServiceNotSuccessfullStates objectInCache = (AccountServiceNotSuccessfullStates)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcNtsucstatesFacade.getClass(?); end;");
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
    public void observerSet(long AccountServiceNotSuccessfullStatesId, PersistentAccountService observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcNtsucstatesFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceNotSuccessfullStatesId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long observeeAdd(long AccountServiceNotSuccessfullStatesId, PersistentDebitTransfer observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcNtsucstatesFacade.obsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AccountServiceNotSuccessfullStatesId);
            callable.setLong(3, observeeVal.getId());
            callable.setLong(4, observeeVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeRem(long observeeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcNtsucstatesFacade.obsRem(?); end;");
            callable.setLong(1, observeeId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferList observeeGet(long AccountServiceNotSuccessfullStatesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcNtsucstatesFacade.obsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountServiceNotSuccessfullStatesId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitTransferList result = new DebitTransferList();
            while (list.next()) {
                result.add((PersistentDebitTransfer)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountServiceNotSuccessfullStatesId, PersistentAccountServiceNotSuccessfullStates ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcNtsucstatesFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceNotSuccessfullStatesId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

