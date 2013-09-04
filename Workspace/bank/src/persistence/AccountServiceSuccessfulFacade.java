package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountServiceSuccessfulFacade{

	private String schemaName;
	private Connection con;

	public AccountServiceSuccessfulFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountServiceSuccessfulProxi newAccountServiceSuccessful(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcSccssflFacade.newAccntSrvcSccssfl(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceSuccessful result = new AccountServiceSuccessful(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceSuccessfulProxi)PersistentProxi.createProxi(id, 220);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceSuccessfulProxi newDelayedAccountServiceSuccessful() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcSccssflFacade.newDelayedAccntSrvcSccssfl(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceSuccessful result = new AccountServiceSuccessful(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceSuccessfulProxi)PersistentProxi.createProxi(id, 220);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceSuccessful getAccountServiceSuccessful(long AccountServiceSuccessfulId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcSccssflFacade.getAccntSrvcSccssfl(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountServiceSuccessfulId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccountService observer = null;
            PersistentDebitTransferSuccessful observee = null;
            PersistentAccountServiceSuccessful This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10267: {
                        observer = (PersistentAccountService)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10268: {
                        observee = (PersistentDebitTransferSuccessful)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10269: {
                        This = (PersistentAccountServiceSuccessful)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            AccountServiceSuccessful result = new AccountServiceSuccessful(observer, 
                                                                           observee, 
                                                                           This, 
                                                                           AccountServiceSuccessfulId);
            links.close();
            callable.close();
            AccountServiceSuccessfulICProxi inCache = (AccountServiceSuccessfulICProxi)Cache.getTheCache().put(result);
            AccountServiceSuccessful objectInCache = (AccountServiceSuccessful)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcSccssflFacade.getClass(?); end;");
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
    public void observerSet(long AccountServiceSuccessfulId, PersistentAccountService observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcSccssflFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceSuccessfulId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AccountServiceSuccessfulId, PersistentDebitTransferSuccessful observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcSccssflFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceSuccessfulId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountServiceSuccessfulId, PersistentAccountServiceSuccessful ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcSccssflFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceSuccessfulId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

