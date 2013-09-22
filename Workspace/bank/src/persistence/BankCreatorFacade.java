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
            return (BankCreatorProxi)PersistentProxi.createProxi(id, 152);
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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            long lastBankNumber = 0;
            SubjInterface subService = null;
            PersistentBankCreator This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10096: {
                        lastBankNumber = links.getLong(5);
                        break;
                    }
                    case 10097: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10098: {
                        This = (PersistentBankCreator)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            BankCreator result = new BankCreator(lastBankNumber, 
                                                 subService, 
                                                 This, 
                                                 BankCreatorId);
            links.close();
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

