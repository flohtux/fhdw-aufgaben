package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class FeeWrapperFacade{

	private String schemaName;
	private Connection con;

	public FeeWrapperFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public FeeWrapperProxi newFeeWrapper(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FWrpprFacade.newFWrppr(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FeeWrapper result = new FeeWrapper(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (FeeWrapperProxi)PersistentProxi.createProxi(id, 242);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FeeWrapperProxi newDelayedFeeWrapper() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FWrpprFacade.newDelayedFWrppr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FeeWrapper result = new FeeWrapper(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (FeeWrapperProxi)PersistentProxi.createProxi(id, 242);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FeeWrapper getFeeWrapper(long FeeWrapperId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FWrpprFacade.getFWrppr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, FeeWrapperId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentTransactionFee fee = null;
            if (obj.getLong(2) != 0)
                fee = (PersistentTransactionFee)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentInternalFee internalFee = null;
            if (obj.getLong(4) != 0)
                internalFee = (PersistentInternalFee)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentFeeWrapper This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentFeeWrapper)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            FeeWrapper result = new FeeWrapper(fee,
                                               internalFee,
                                               subService,
                                               This,
                                               FeeWrapperId);
            obj.close();
            callable.close();
            FeeWrapperICProxi inCache = (FeeWrapperICProxi)Cache.getTheCache().put(result);
            FeeWrapper objectInCache = (FeeWrapper)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FWrpprFacade.getClass(?); end;");
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
    public void feeSet(long FeeWrapperId, PersistentTransactionFee feeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FWrpprFacade.feeSet(?, ?, ?); end;");
            callable.setLong(1, FeeWrapperId);
            callable.setLong(2, feeVal.getId());
            callable.setLong(3, feeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void internalFeeSet(long FeeWrapperId, PersistentInternalFee internalFeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FWrpprFacade.intrnlFSet(?, ?, ?); end;");
            callable.setLong(1, FeeWrapperId);
            callable.setLong(2, internalFeeVal.getId());
            callable.setLong(3, internalFeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long FeeWrapperId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FWrpprFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, FeeWrapperId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long FeeWrapperId, PersistentFeeWrapper ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FWrpprFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, FeeWrapperId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

