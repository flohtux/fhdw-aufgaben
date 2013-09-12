package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AdministratorFacade{

	private String schemaName;
	private Connection con;

	public AdministratorFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AdministratorProxi newAdministrator(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrFacade.newAdmnstrtr(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Administrator result = new Administrator(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AdministratorProxi)PersistentProxi.createProxi(id, -117);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AdministratorProxi newDelayedAdministrator() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrFacade.newDelayedAdmnstrtr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Administrator result = new Administrator(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AdministratorProxi)PersistentProxi.createProxi(id, -117);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Administrator getAdministrator(long AdministratorId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AdmnstrtrFacade.getAdmnstrtr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AdministratorId);
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
            PersistentAdministratorCurrencyManager currencyManager = null;
            if (obj.getLong(6) != 0)
                currencyManager = (PersistentAdministratorCurrencyManager)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentAdministratorBanks banks = null;
            if (obj.getLong(8) != 0)
                banks = (PersistentAdministratorBanks)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            Administrator result = new Administrator(subService,
                                                     This,
                                                     currencyManager,
                                                     banks,
                                                     AdministratorId);
            obj.close();
            callable.close();
            AdministratorICProxi inCache = (AdministratorICProxi)Cache.getTheCache().put(result);
            Administrator objectInCache = (Administrator)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void currencyManagerSet(long AdministratorId, PersistentAdministratorCurrencyManager currencyManagerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnstrtrFacade.crrncMngrSet(?, ?, ?); end;");
            callable.setLong(1, AdministratorId);
            callable.setLong(2, currencyManagerVal.getId());
            callable.setLong(3, currencyManagerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void banksSet(long AdministratorId, PersistentAdministratorBanks banksVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AdmnstrtrFacade.bnksSet(?, ?, ?); end;");
            callable.setLong(1, AdministratorId);
            callable.setLong(2, banksVal.getId());
            callable.setLong(3, banksVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

