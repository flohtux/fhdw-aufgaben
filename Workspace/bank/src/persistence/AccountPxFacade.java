package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountPxFacade{

	private String schemaName;
	private Connection con;

	public AccountPxFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountPxProxi newAccountPx(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntPxFacade.newAccntPx(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountPx result = new AccountPx(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountPxProxi)PersistentProxi.createProxi(id, 203);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountPxProxi newDelayedAccountPx() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntPxFacade.newDelayedAccntPx(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountPx result = new AccountPx(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountPxProxi)PersistentProxi.createProxi(id, 203);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountPx getAccountPx(long AccountPxId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntPxFacade.getAccntPx(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountPxId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccount account = null;
            SubjInterface subService = null;
            PersistentAccountPx This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10210: {
                        account = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10211: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10212: {
                        This = (PersistentAccountPx)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            AccountPx result = new AccountPx(account, 
                                             subService, 
                                             This, 
                                             AccountPxId);
            links.close();
            callable.close();
            AccountPxICProxi inCache = (AccountPxICProxi)Cache.getTheCache().put(result);
            AccountPx objectInCache = (AccountPx)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntPxFacade.getClass(?); end;");
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
    public void accountSet(long AccountPxId, PersistentAccount accountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntPxFacade.accntSet(?, ?, ?); end;");
            callable.setLong(1, AccountPxId);
            callable.setLong(2, accountVal.getId());
            callable.setLong(3, accountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long AccountPxId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntPxFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, AccountPxId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountPxId, PersistentAccountPx ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntPxFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountPxId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

