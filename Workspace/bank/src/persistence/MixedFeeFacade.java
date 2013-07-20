package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class MixedFeeFacade{

	private String schemaName;
	private Connection con;

	public MixedFeeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public MixedFeeProxi newMixedFee(long limit,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MxdFFacade.newMxdF(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, limit);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MixedFee result = new MixedFee(null,null,null,null,limit,id);
            Cache.getTheCache().put(result);
            return (MixedFeeProxi)PersistentProxi.createProxi(id, 129);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MixedFeeProxi newDelayedMixedFee(long limit) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MxdFFacade.newDelayedMxdF(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MixedFee result = new MixedFee(null,null,null,null,limit,id);
            Cache.getTheCache().put(result);
            return (MixedFeeProxi)PersistentProxi.createProxi(id, 129);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MixedFee getMixedFee(long MixedFeeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".MxdFFacade.getMxdF(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, MixedFeeId);
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
            PersistentTransactionFee This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentTransactionFee)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentFixTransactionFee fix = null;
            if (obj.getLong(6) != 0)
                fix = (PersistentFixTransactionFee)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentProcentualFee procentual = null;
            if (obj.getLong(8) != 0)
                procentual = (PersistentProcentualFee)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            MixedFee result = new MixedFee(subService,
                                           This,
                                           fix,
                                           procentual,
                                           obj.getLong(10),
                                           MixedFeeId);
            obj.close();
            callable.close();
            MixedFeeICProxi inCache = (MixedFeeICProxi)Cache.getTheCache().put(result);
            MixedFee objectInCache = (MixedFee)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void fixSet(long MixedFeeId, PersistentFixTransactionFee fixVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MxdFFacade.fxSet(?, ?, ?); end;");
            callable.setLong(1, MixedFeeId);
            callable.setLong(2, fixVal.getId());
            callable.setLong(3, fixVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void procentualSet(long MixedFeeId, PersistentProcentualFee procentualVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MxdFFacade.prcntlSet(?, ?, ?); end;");
            callable.setLong(1, MixedFeeId);
            callable.setLong(2, procentualVal.getId());
            callable.setLong(3, procentualVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void limitSet(long MixedFeeId, long limitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MxdFFacade.lmtSet(?, ?); end;");
            callable.setLong(1, MixedFeeId);
            callable.setLong(2, limitVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

