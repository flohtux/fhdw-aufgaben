package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class InternalFeeFacade{

	private String schemaName;
	private Connection con;

	public InternalFeeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public InternalFeeProxi newInternalFee(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".IntrnlFFacade.newIntrnlF(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            InternalFee result = new InternalFee(null,null,null,id);
            Cache.getTheCache().put(result);
            return (InternalFeeProxi)PersistentProxi.createProxi(id, 109);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public InternalFeeProxi newDelayedInternalFee() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".IntrnlFFacade.newDelayedIntrnlF(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            InternalFee result = new InternalFee(null,null,null,id);
            Cache.getTheCache().put(result);
            return (InternalFeeProxi)PersistentProxi.createProxi(id, 109);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public InternalFee getInternalFee(long InternalFeeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".IntrnlFFacade.getIntrnlF(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, InternalFeeId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentPercent percent = null;
            if (obj.getLong(2) != 0)
                percent = (PersistentPercent)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            SubjInterface subService = null;
            if (obj.getLong(4) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentInternalFee This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentInternalFee)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            InternalFee result = new InternalFee(percent,
                                                 subService,
                                                 This,
                                                 InternalFeeId);
            obj.close();
            callable.close();
            InternalFeeICProxi inCache = (InternalFeeICProxi)Cache.getTheCache().put(result);
            InternalFee objectInCache = (InternalFee)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".IntrnlFFacade.getClass(?); end;");
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
    public void percentSet(long InternalFeeId, PersistentPercent percentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".IntrnlFFacade.prcntSet(?, ?, ?); end;");
            callable.setLong(1, InternalFeeId);
            callable.setLong(2, percentVal.getId());
            callable.setLong(3, percentVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long InternalFeeId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".IntrnlFFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, InternalFeeId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long InternalFeeId, PersistentInternalFee ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".IntrnlFFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, InternalFeeId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

