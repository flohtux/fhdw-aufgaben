package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountServiceSuccessfullStatesFacade{

	private String schemaName;
	private Connection con;

	public AccountServiceSuccessfullStatesFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountServiceSuccessfullStatesProxi newAccountServiceSuccessfullStates(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcSucstatesFacade.newAccntSrvcSucstates(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceSuccessfullStates result = new AccountServiceSuccessfullStates(null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceSuccessfullStatesProxi)PersistentProxi.createProxi(id, 194);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceSuccessfullStatesProxi newDelayedAccountServiceSuccessfullStates() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcSucstatesFacade.newDelayedAccntSrvcSucstates(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceSuccessfullStates result = new AccountServiceSuccessfullStates(null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceSuccessfullStatesProxi)PersistentProxi.createProxi(id, 194);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceSuccessfullStates getAccountServiceSuccessfullStates(long AccountServiceSuccessfullStatesId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcSucstatesFacade.getAccntSrvcSucstates(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountServiceSuccessfullStatesId);
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
            PersistentAccountServiceSuccessfullStates This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentAccountServiceSuccessfullStates)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            AccountServiceSuccessfullStates result = new AccountServiceSuccessfullStates(observer,
                                                                                         This,
                                                                                         AccountServiceSuccessfullStatesId);
            obj.close();
            callable.close();
            AccountServiceSuccessfullStatesICProxi inCache = (AccountServiceSuccessfullStatesICProxi)Cache.getTheCache().put(result);
            AccountServiceSuccessfullStates objectInCache = (AccountServiceSuccessfullStates)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcSucstatesFacade.getClass(?); end;");
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
    public void observerSet(long AccountServiceSuccessfullStatesId, PersistentAccountService observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcSucstatesFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceSuccessfullStatesId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long observeeAdd(long AccountServiceSuccessfullStatesId, PersistentDebitTransfer observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcSucstatesFacade.obsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, AccountServiceSuccessfullStatesId);
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
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcSucstatesFacade.obsRem(?); end;");
            callable.setLong(1, observeeId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferList observeeGet(long AccountServiceSuccessfullStatesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcSucstatesFacade.obsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountServiceSuccessfullStatesId);
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
    public void ThisSet(long AccountServiceSuccessfullStatesId, PersistentAccountServiceSuccessfullStates ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcSucstatesFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceSuccessfullStatesId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

