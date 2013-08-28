package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountMoney2Facade{

	private String schemaName;
	private Connection con;

	public AccountMoney2Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountMoney2Proxi newAccountMoney2(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntMn2Facade.newAccntMn2(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountMoney2 result = new AccountMoney2(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountMoney2Proxi)PersistentProxi.createProxi(id, 224);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountMoney2Proxi newDelayedAccountMoney2() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntMn2Facade.newDelayedAccntMn2(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountMoney2 result = new AccountMoney2(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountMoney2Proxi)PersistentProxi.createProxi(id, 224);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountMoney2 getAccountMoney2(long AccountMoney2Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntMn2Facade.getAccntMn2(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountMoney2Id);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAccount observer = null;
            if (obj.getLong(2) != 0)
                observer = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMoney observee = null;
            if (obj.getLong(4) != 0)
                observee = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAccountMoney2 This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentAccountMoney2)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            AccountMoney2 result = new AccountMoney2(observer,
                                                     observee,
                                                     This,
                                                     AccountMoney2Id);
            obj.close();
            callable.close();
            AccountMoney2ICProxi inCache = (AccountMoney2ICProxi)Cache.getTheCache().put(result);
            AccountMoney2 objectInCache = (AccountMoney2)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntMn2Facade.getClass(?); end;");
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
    public void observerSet(long AccountMoney2Id, PersistentAccount observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntMn2Facade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountMoney2Id);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AccountMoney2Id, PersistentMoney observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntMn2Facade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AccountMoney2Id);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountMoney2Id, PersistentAccountMoney2 ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntMn2Facade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountMoney2Id);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

