package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class BankServiceFacade{

	private String schemaName;
	private Connection con;

	public BankServiceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public BankServiceProxi newBankService(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkSrvcFacade.newBnkSrvc(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BankService result = new BankService(null,null,null,id);
            Cache.getTheCache().put(result);
            return (BankServiceProxi)PersistentProxi.createProxi(id, -119);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BankServiceProxi newDelayedBankService() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkSrvcFacade.newDelayedBnkSrvc(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BankService result = new BankService(null,null,null,id);
            Cache.getTheCache().put(result);
            return (BankServiceProxi)PersistentProxi.createProxi(id, -119);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BankService getBankService(long BankServiceId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkSrvcFacade.getBnkSrvc(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, BankServiceId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentService This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentService)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentBank bank = null;
            if (obj.getLong(6) != 0)
                bank = (PersistentBank)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            BankService result = new BankService(subService,
                                                 This,
                                                 bank,
                                                 BankServiceId);
            obj.close();
            callable.close();
            BankServiceICProxi inCache = (BankServiceICProxi)Cache.getTheCache().put(result);
            BankService objectInCache = (BankService)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void bankSet(long BankServiceId, PersistentBank bankVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkSrvcFacade.bnkSet(?, ?, ?); end;");
            callable.setLong(1, BankServiceId);
            callable.setLong(2, bankVal.getId());
            callable.setLong(3, bankVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public BankServiceSearchList inverseGetBank(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkSrvcFacade.iGetBnk(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            BankServiceSearchList result = new BankServiceSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentBankService)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentBankService)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

