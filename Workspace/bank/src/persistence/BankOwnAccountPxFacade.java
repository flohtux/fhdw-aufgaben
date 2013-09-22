package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class BankOwnAccountPxFacade{

	private String schemaName;
	private Connection con;

	public BankOwnAccountPxFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public BankOwnAccountPxProxi newBankOwnAccountPx(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BankOwAccPxFacade.newBankOwAccPx(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BankOwnAccountPx result = new BankOwnAccountPx(null,null,null,id);
            Cache.getTheCache().put(result);
            return (BankOwnAccountPxProxi)PersistentProxi.createProxi(id, 262);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BankOwnAccountPxProxi newDelayedBankOwnAccountPx() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BankOwAccPxFacade.newDelayedBankOwAccPx(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BankOwnAccountPx result = new BankOwnAccountPx(null,null,null,id);
            Cache.getTheCache().put(result);
            return (BankOwnAccountPxProxi)PersistentProxi.createProxi(id, 262);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BankOwnAccountPx getBankOwnAccountPx(long BankOwnAccountPxId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BankOwAccPxFacade.getBankOwAccPx(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, BankOwnAccountPxId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccount account = null;
            SubjInterface subService = null;
            PersistentBankOwnAccountPx This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10385: {
                        account = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10386: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10387: {
                        This = (PersistentBankOwnAccountPx)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            BankOwnAccountPx result = new BankOwnAccountPx(account, 
                                                           subService, 
                                                           This, 
                                                           BankOwnAccountPxId);
            links.close();
            callable.close();
            BankOwnAccountPxICProxi inCache = (BankOwnAccountPxICProxi)Cache.getTheCache().put(result);
            BankOwnAccountPx objectInCache = (BankOwnAccountPx)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BankOwAccPxFacade.getClass(?); end;");
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
    public void accountSet(long BankOwnAccountPxId, PersistentAccount accountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BankOwAccPxFacade.accntSet(?, ?, ?); end;");
            callable.setLong(1, BankOwnAccountPxId);
            callable.setLong(2, accountVal.getId());
            callable.setLong(3, accountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long BankOwnAccountPxId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BankOwAccPxFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, BankOwnAccountPxId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long BankOwnAccountPxId, PersistentBankOwnAccountPx ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BankOwAccPxFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, BankOwnAccountPxId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

