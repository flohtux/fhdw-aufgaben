package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class BankPxFacade{

	private String schemaName;
	private Connection con;

	public BankPxFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public BankPxProxi newBankPx(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkPxFacade.newBnkPx(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BankPx result = new BankPx(null,null,null,id);
            Cache.getTheCache().put(result);
            return (BankPxProxi)PersistentProxi.createProxi(id, 241);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BankPxProxi newDelayedBankPx() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkPxFacade.newDelayedBnkPx(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BankPx result = new BankPx(null,null,null,id);
            Cache.getTheCache().put(result);
            return (BankPxProxi)PersistentProxi.createProxi(id, 241);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BankPx getBankPx(long BankPxId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkPxFacade.getBnkPx(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, BankPxId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentBank bank = null;
            if (obj.getLong(2) != 0)
                bank = (PersistentBank)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            SubjInterface subService = null;
            if (obj.getLong(4) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentBankPx This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentBankPx)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            BankPx result = new BankPx(bank,
                                       subService,
                                       This,
                                       BankPxId);
            obj.close();
            callable.close();
            BankPxICProxi inCache = (BankPxICProxi)Cache.getTheCache().put(result);
            BankPx objectInCache = (BankPx)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkPxFacade.getClass(?); end;");
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
    public void bankSet(long BankPxId, PersistentBank bankVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkPxFacade.bnkSet(?, ?, ?); end;");
            callable.setLong(1, BankPxId);
            callable.setLong(2, bankVal.getId());
            callable.setLong(3, bankVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long BankPxId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkPxFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, BankPxId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long BankPxId, PersistentBankPx ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkPxFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, BankPxId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

