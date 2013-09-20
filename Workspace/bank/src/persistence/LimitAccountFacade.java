package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class LimitAccountFacade{

	private String schemaName;
	private Connection con;

	public LimitAccountFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public LimitAccountProxi newLimitAccount(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".LmtAccntFacade.newLmtAccnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            LimitAccount result = new LimitAccount(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (LimitAccountProxi)PersistentProxi.createProxi(id, 127);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public LimitAccountProxi newDelayedLimitAccount() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".LmtAccntFacade.newDelayedLmtAccnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            LimitAccount result = new LimitAccount(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (LimitAccountProxi)PersistentProxi.createProxi(id, 127);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public LimitAccount getLimitAccount(long LimitAccountId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LmtAccntFacade.getLmtAccnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, LimitAccountId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentLimitType minLimit = null;
            if (obj.getLong(2) != 0)
                minLimit = (PersistentLimitType)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentLimitType maxLimit = null;
            if (obj.getLong(4) != 0)
                maxLimit = (PersistentLimitType)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentLimitAccount This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentLimitAccount)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            LimitAccount result = new LimitAccount(minLimit,
                                                   maxLimit,
                                                   subService,
                                                   This,
                                                   LimitAccountId);
            obj.close();
            callable.close();
            LimitAccountICProxi inCache = (LimitAccountICProxi)Cache.getTheCache().put(result);
            LimitAccount objectInCache = (LimitAccount)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LmtAccntFacade.getClass(?); end;");
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
    public void minLimitSet(long LimitAccountId, PersistentLimitType minLimitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LmtAccntFacade.mnLmtSet(?, ?, ?); end;");
            callable.setLong(1, LimitAccountId);
            callable.setLong(2, minLimitVal.getId());
            callable.setLong(3, minLimitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void maxLimitSet(long LimitAccountId, PersistentLimitType maxLimitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LmtAccntFacade.mxLmtSet(?, ?, ?); end;");
            callable.setLong(1, LimitAccountId);
            callable.setLong(2, maxLimitVal.getId());
            callable.setLong(3, maxLimitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long LimitAccountId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LmtAccntFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, LimitAccountId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long LimitAccountId, PersistentLimitAccount ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LmtAccntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, LimitAccountId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

