package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountGrantedDebitGrantFacade{

	private String schemaName;
	private Connection con;

	public AccountGrantedDebitGrantFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountGrantedDebitGrantProxi newAccountGrantedDebitGrant(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntGrntdGrntFacade.newAccntGrntdGrnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountGrantedDebitGrant result = new AccountGrantedDebitGrant(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountGrantedDebitGrantProxi)PersistentProxi.createProxi(id, 206);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountGrantedDebitGrantProxi newDelayedAccountGrantedDebitGrant() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntGrntdGrntFacade.newDelayedAccntGrntdGrnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountGrantedDebitGrant result = new AccountGrantedDebitGrant(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountGrantedDebitGrantProxi)PersistentProxi.createProxi(id, 206);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountGrantedDebitGrant getAccountGrantedDebitGrant(long AccountGrantedDebitGrantId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntGrntdGrntFacade.getAccntGrntdGrnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountGrantedDebitGrantId);
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
            PersistentDebitGrantListe observee = null;
            if (obj.getLong(4) != 0)
                observee = (PersistentDebitGrantListe)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAccountGrantedDebitGrant This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentAccountGrantedDebitGrant)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            AccountGrantedDebitGrant result = new AccountGrantedDebitGrant(observer,
                                                                           observee,
                                                                           This,
                                                                           AccountGrantedDebitGrantId);
            obj.close();
            callable.close();
            AccountGrantedDebitGrantICProxi inCache = (AccountGrantedDebitGrantICProxi)Cache.getTheCache().put(result);
            AccountGrantedDebitGrant objectInCache = (AccountGrantedDebitGrant)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntGrntdGrntFacade.getClass(?); end;");
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
    public void observerSet(long AccountGrantedDebitGrantId, PersistentAccount observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntGrntdGrntFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountGrantedDebitGrantId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AccountGrantedDebitGrantId, PersistentDebitGrantListe observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntGrntdGrntFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AccountGrantedDebitGrantId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountGrantedDebitGrantId, PersistentAccountGrantedDebitGrant ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntGrntdGrntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountGrantedDebitGrantId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

