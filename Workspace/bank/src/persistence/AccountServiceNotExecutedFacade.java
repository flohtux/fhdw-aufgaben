package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountServiceNotExecutedFacade{

	private String schemaName;
	private Connection con;

	public AccountServiceNotExecutedFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountServiceNotExecutedProxi newAccountServiceNotExecuted(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcNtExctdFacade.newAccntSrvcNtExctd(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceNotExecuted result = new AccountServiceNotExecuted(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceNotExecutedProxi)PersistentProxi.createProxi(id, 221);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceNotExecutedProxi newDelayedAccountServiceNotExecuted() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcNtExctdFacade.newDelayedAccntSrvcNtExctd(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceNotExecuted result = new AccountServiceNotExecuted(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceNotExecutedProxi)PersistentProxi.createProxi(id, 221);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceNotExecuted getAccountServiceNotExecuted(long AccountServiceNotExecutedId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcNtExctdFacade.getAccntSrvcNtExctd(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountServiceNotExecutedId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccountService observer = null;
            PersistentDebitTransferNotExecuted observee = null;
            PersistentAccountServiceNotExecuted This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10270: {
                        observer = (PersistentAccountService)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10271: {
                        observee = (PersistentDebitTransferNotExecuted)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10272: {
                        This = (PersistentAccountServiceNotExecuted)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            AccountServiceNotExecuted result = new AccountServiceNotExecuted(observer, 
                                                                             observee, 
                                                                             This, 
                                                                             AccountServiceNotExecutedId);
            links.close();
            callable.close();
            AccountServiceNotExecutedICProxi inCache = (AccountServiceNotExecutedICProxi)Cache.getTheCache().put(result);
            AccountServiceNotExecuted objectInCache = (AccountServiceNotExecuted)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcNtExctdFacade.getClass(?); end;");
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
    public void observerSet(long AccountServiceNotExecutedId, PersistentAccountService observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcNtExctdFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceNotExecutedId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AccountServiceNotExecutedId, PersistentDebitTransferNotExecuted observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcNtExctdFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceNotExecutedId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountServiceNotExecutedId, PersistentAccountServiceNotExecuted ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcNtExctdFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceNotExecutedId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

