package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class LimitFacade{

	private String schemaName;
	private Connection con;

	public LimitFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public LimitProxi newLimit(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".LmtFacade.newLmt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Limit result = new Limit(null,null,null,id);
            Cache.getTheCache().put(result);
            return (LimitProxi)PersistentProxi.createProxi(id, 128);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public LimitProxi newDelayedLimit() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".LmtFacade.newDelayedLmt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Limit result = new Limit(null,null,null,id);
            Cache.getTheCache().put(result);
            return (LimitProxi)PersistentProxi.createProxi(id, 128);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Limit getLimit(long LimitId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LmtFacade.getLmt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, LimitId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentLimitType This = null;
            PersistentMoney money = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10070: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10071: {
                        This = (PersistentLimitType)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10054: {
                        money = (PersistentMoney)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            Limit result = new Limit(subService, 
                                     This, 
                                     money, 
                                     LimitId);
            links.close();
            callable.close();
            LimitICProxi inCache = (LimitICProxi)Cache.getTheCache().put(result);
            Limit objectInCache = (Limit)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void moneySet(long LimitId, PersistentMoney moneyVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LmtFacade.mnSet(?, ?, ?); end;");
            callable.setLong(1, LimitId);
            callable.setLong(2, moneyVal.getId());
            callable.setLong(3, moneyVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

