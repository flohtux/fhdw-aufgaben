package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountServiceBankFeesFacade{

	private String schemaName;
	private Connection con;

	public AccountServiceBankFeesFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountServiceBankFeesProxi newAccountServiceBankFees(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcBnkFsFacade.newAccntSrvcBnkFs(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceBankFees result = new AccountServiceBankFees(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceBankFeesProxi)PersistentProxi.createProxi(id, 245);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceBankFeesProxi newDelayedAccountServiceBankFees() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcBnkFsFacade.newDelayedAccntSrvcBnkFs(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceBankFees result = new AccountServiceBankFees(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceBankFeesProxi)PersistentProxi.createProxi(id, 245);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceBankFees getAccountServiceBankFees(long AccountServiceBankFeesId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcBnkFsFacade.getAccntSrvcBnkFs(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountServiceBankFeesId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccountService observer = null;
            PersistentBankFees observee = null;
            PersistentAccountServiceBankFees This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10343: {
                        observer = (PersistentAccountService)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10344: {
                        observee = (PersistentBankFees)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10345: {
                        This = (PersistentAccountServiceBankFees)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            AccountServiceBankFees result = new AccountServiceBankFees(observer, 
                                                                       observee, 
                                                                       This, 
                                                                       AccountServiceBankFeesId);
            links.close();
            callable.close();
            AccountServiceBankFeesICProxi inCache = (AccountServiceBankFeesICProxi)Cache.getTheCache().put(result);
            AccountServiceBankFees objectInCache = (AccountServiceBankFees)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcBnkFsFacade.getClass(?); end;");
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
    public void observerSet(long AccountServiceBankFeesId, PersistentAccountService observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcBnkFsFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceBankFeesId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AccountServiceBankFeesId, PersistentBankFees observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcBnkFsFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceBankFeesId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountServiceBankFeesId, PersistentAccountServiceBankFees ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcBnkFsFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceBankFeesId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

