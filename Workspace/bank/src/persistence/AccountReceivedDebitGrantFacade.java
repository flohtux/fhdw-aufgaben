package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountReceivedDebitGrantFacade{

	private String schemaName;
	private Connection con;

	public AccountReceivedDebitGrantFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountReceivedDebitGrantProxi newAccountReceivedDebitGrant(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntRcvdGrntFacade.newAccntRcvdGrnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountReceivedDebitGrant result = new AccountReceivedDebitGrant(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountReceivedDebitGrantProxi)PersistentProxi.createProxi(id, 205);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountReceivedDebitGrantProxi newDelayedAccountReceivedDebitGrant() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntRcvdGrntFacade.newDelayedAccntRcvdGrnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountReceivedDebitGrant result = new AccountReceivedDebitGrant(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountReceivedDebitGrantProxi)PersistentProxi.createProxi(id, 205);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountReceivedDebitGrant getAccountReceivedDebitGrant(long AccountReceivedDebitGrantId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntRcvdGrntFacade.getAccntRcvdGrnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountReceivedDebitGrantId);
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
            PersistentAccountReceivedDebitGrant This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentAccountReceivedDebitGrant)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            AccountReceivedDebitGrant result = new AccountReceivedDebitGrant(observer,
                                                                             observee,
                                                                             This,
                                                                             AccountReceivedDebitGrantId);
            obj.close();
            callable.close();
            AccountReceivedDebitGrantICProxi inCache = (AccountReceivedDebitGrantICProxi)Cache.getTheCache().put(result);
            AccountReceivedDebitGrant objectInCache = (AccountReceivedDebitGrant)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntRcvdGrntFacade.getClass(?); end;");
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
    public void observerSet(long AccountReceivedDebitGrantId, PersistentAccount observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntRcvdGrntFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountReceivedDebitGrantId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AccountReceivedDebitGrantId, PersistentDebitGrantListe observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntRcvdGrntFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AccountReceivedDebitGrantId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountReceivedDebitGrantId, PersistentAccountReceivedDebitGrant ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntRcvdGrntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountReceivedDebitGrantId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

