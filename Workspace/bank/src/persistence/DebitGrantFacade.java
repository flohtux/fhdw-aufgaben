package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DebitGrantFacade{

	private String schemaName;
	private Connection con;

	public DebitGrantFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DebitGrantProxi newDebitGrant(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtGrntFacade.newDbtGrnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitGrant result = new DebitGrant(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (DebitGrantProxi)PersistentProxi.createProxi(id, 191);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitGrantProxi newDelayedDebitGrant() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtGrntFacade.newDelayedDbtGrnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitGrant result = new DebitGrant(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (DebitGrantProxi)PersistentProxi.createProxi(id, 191);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitGrant getDebitGrant(long DebitGrantId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtGrntFacade.getDbtGrnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitGrantId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAccountPx permittedAccount = null;
            if (obj.getLong(2) != 0)
                permittedAccount = (PersistentAccountPx)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentLimitType limits = null;
            if (obj.getLong(4) != 0)
                limits = (PersistentLimitType)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentDebitGrant This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentDebitGrant)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            DebitGrant result = new DebitGrant(permittedAccount,
                                               limits,
                                               subService,
                                               This,
                                               DebitGrantId);
            obj.close();
            callable.close();
            DebitGrantICProxi inCache = (DebitGrantICProxi)Cache.getTheCache().put(result);
            DebitGrant objectInCache = (DebitGrant)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtGrntFacade.getClass(?); end;");
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
    public void permittedAccountSet(long DebitGrantId, PersistentAccountPx permittedAccountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtGrntFacade.prmttdAccntSet(?, ?, ?); end;");
            callable.setLong(1, DebitGrantId);
            callable.setLong(2, permittedAccountVal.getId());
            callable.setLong(3, permittedAccountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void limitsSet(long DebitGrantId, PersistentLimitType limitsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtGrntFacade.lmtsSet(?, ?, ?); end;");
            callable.setLong(1, DebitGrantId);
            callable.setLong(2, limitsVal.getId());
            callable.setLong(3, limitsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long DebitGrantId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtGrntFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitGrantId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitGrantId, PersistentDebitGrant ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtGrntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitGrantId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

