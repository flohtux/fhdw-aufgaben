package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class BankFeesFacade{

	private String schemaName;
	private Connection con;

	public BankFeesFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public BankFeesProxi newBankFees(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFsFacade.newBnkFs(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BankFees result = new BankFees(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (BankFeesProxi)PersistentProxi.createProxi(id, 244);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BankFeesProxi newDelayedBankFees() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFsFacade.newDelayedBnkFs(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BankFees result = new BankFees(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (BankFeesProxi)PersistentProxi.createProxi(id, 244);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BankFees getBankFees(long BankFeesId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFsFacade.getBnkFs(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, BankFeesId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentTransactionFee fee = null;
            PersistentInternalFee internalFee = null;
            SubjInterface subService = null;
            PersistentBankFees This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10339: {
                        fee = (PersistentTransactionFee)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10340: {
                        internalFee = (PersistentInternalFee)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10341: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10342: {
                        This = (PersistentBankFees)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            BankFees result = new BankFees(fee, 
                                           internalFee, 
                                           subService, 
                                           This, 
                                           BankFeesId);
            links.close();
            callable.close();
            BankFeesICProxi inCache = (BankFeesICProxi)Cache.getTheCache().put(result);
            BankFees objectInCache = (BankFees)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkFsFacade.getClass(?); end;");
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
    public void feeSet(long BankFeesId, PersistentTransactionFee feeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFsFacade.feeSet(?, ?, ?); end;");
            callable.setLong(1, BankFeesId);
            callable.setLong(2, feeVal.getId());
            callable.setLong(3, feeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void internalFeeSet(long BankFeesId, PersistentInternalFee internalFeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFsFacade.intrnlFSet(?, ?, ?); end;");
            callable.setLong(1, BankFeesId);
            callable.setLong(2, internalFeeVal.getId());
            callable.setLong(3, internalFeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long BankFeesId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFsFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, BankFeesId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long BankFeesId, PersistentBankFees ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkFsFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, BankFeesId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

