package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountAllCompensationFacade{

	private String schemaName;
	private Connection con;

	public AccountAllCompensationFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountAllCompensationProxi newAccountAllCompensation(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntAllCmpnstnFacade.newAccntAllCmpnstn(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountAllCompensation result = new AccountAllCompensation(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountAllCompensationProxi)PersistentProxi.createProxi(id, 271);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountAllCompensationProxi newDelayedAccountAllCompensation() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntAllCmpnstnFacade.newDelayedAccntAllCmpnstn(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountAllCompensation result = new AccountAllCompensation(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountAllCompensationProxi)PersistentProxi.createProxi(id, 271);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountAllCompensation getAccountAllCompensation(long AccountAllCompensationId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntAllCmpnstnFacade.getAccntAllCmpnstn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountAllCompensationId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccount observer = null;
            PersistentAllCompensationListe observee = null;
            PersistentAccountAllCompensation This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10406: {
                        observer = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10407: {
                        observee = (PersistentAllCompensationListe)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10408: {
                        This = (PersistentAccountAllCompensation)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            AccountAllCompensation result = new AccountAllCompensation(observer, 
                                                                       observee, 
                                                                       This, 
                                                                       AccountAllCompensationId);
            links.close();
            callable.close();
            AccountAllCompensationICProxi inCache = (AccountAllCompensationICProxi)Cache.getTheCache().put(result);
            AccountAllCompensation objectInCache = (AccountAllCompensation)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntAllCmpnstnFacade.getClass(?); end;");
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
    public void observerSet(long AccountAllCompensationId, PersistentAccount observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntAllCmpnstnFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountAllCompensationId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AccountAllCompensationId, PersistentAllCompensationListe observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntAllCmpnstnFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AccountAllCompensationId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountAllCompensationId, PersistentAccountAllCompensation ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntAllCmpnstnFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountAllCompensationId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

