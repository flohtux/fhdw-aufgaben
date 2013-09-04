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

    public MixedFeeProxi newMixedFee(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MxdFFacade.newMxdF(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MixedFee result = new MixedFee(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (MixedFeeProxi)PersistentProxi.createProxi(id, 129);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public MixedFeeProxi newDelayedMixedFee() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".MxdFFacade.newDelayedMxdF(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            MixedFee result = new MixedFee(null,null,null,null,null,id);
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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentTransactionFee This = null;
            PersistentFixTransactionFee fix = null;
            PersistentProcentualFee procentual = null;
            PersistentMoney limit = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10059: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10060: {
                        This = (PersistentTransactionFee)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10055: {
                        fix = (PersistentFixTransactionFee)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10056: {
                        procentual = (PersistentProcentualFee)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10057: {
                        limit = (PersistentMoney)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            MixedFee result = new MixedFee(subService, 
                                           This, 
                                           fix, 
                                           procentual, 
                                           limit, 
                                           MixedFeeId);
            links.close();
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
    public void limitSet(long MixedFeeId, PersistentMoney limitVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".MxdFFacade.lmtSet(?, ?, ?); end;");
            callable.setLong(1, MixedFeeId);
            callable.setLong(2, limitVal.getId());
            callable.setLong(3, limitVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

