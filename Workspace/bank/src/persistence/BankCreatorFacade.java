package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class BankCreatorFacade{

	private String schemaName;
	private Connection con;

	public BankCreatorFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public BankCreatorProxi getTheBankCreator() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkCrtrFacade.getTheBnkCrtr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (BankCreatorProxi)PersistentProxi.createProxi(id, 123);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BankCreator getBankCreator(long BankCreatorId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkCrtrFacade.getBnkCrtr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, BankCreatorId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(3) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentBankCreator This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentBankCreator)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            BankCreator result = new BankCreator(obj.getLong(2),
                                                 subService,
                                                 This,
                                                 BankCreatorId);
            obj.close();
            callable.close();
            BankCreatorICProxi inCache = (BankCreatorICProxi)Cache.getTheCache().put(result);
            BankCreator objectInCache = (BankCreator)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BnkCrtrFacade.getClass(?); end;");
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
    public void lastBankNumberSet(long BankCreatorId, long lastBankNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkCrtrFacade.lstBnkNmbrSet(?, ?); end;");
            callable.setLong(1, BankCreatorId);
            callable.setLong(2, lastBankNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long BankCreatorId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkCrtrFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, BankCreatorId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long BankCreatorId, PersistentBankCreator ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BnkCrtrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, BankCreatorId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

