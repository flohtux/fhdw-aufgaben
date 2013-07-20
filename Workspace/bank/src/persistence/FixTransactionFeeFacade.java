package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class FixTransactionFeeFacade{

	private String schemaName;
	private Connection con;

	public FixTransactionFeeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public FixTransactionFeeProxi newFixTransactionFee(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FxTrnsctnFFacade.newFxTrnsctnF(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FixTransactionFee result = new FixTransactionFee(null,null,null,id);
            Cache.getTheCache().put(result);
            return (FixTransactionFeeProxi)PersistentProxi.createProxi(id, 108);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FixTransactionFeeProxi newDelayedFixTransactionFee() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FxTrnsctnFFacade.newDelayedFxTrnsctnF(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FixTransactionFee result = new FixTransactionFee(null,null,null,id);
            Cache.getTheCache().put(result);
            return (FixTransactionFeeProxi)PersistentProxi.createProxi(id, 108);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FixTransactionFee getFixTransactionFee(long FixTransactionFeeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FxTrnsctnFFacade.getFxTrnsctnF(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, FixTransactionFeeId);
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
            PersistentMoney value = null;
            if (obj.getLong(6) != 0)
                value = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            FixTransactionFee result = new FixTransactionFee(subService,
                                                             This,
                                                             value,
                                                             FixTransactionFeeId);
            obj.close();
            callable.close();
            FixTransactionFeeICProxi inCache = (FixTransactionFeeICProxi)Cache.getTheCache().put(result);
            FixTransactionFee objectInCache = (FixTransactionFee)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void valueSet(long FixTransactionFeeId, PersistentMoney valueVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FxTrnsctnFFacade.vlSet(?, ?, ?); end;");
            callable.setLong(1, FixTransactionFeeId);
            callable.setLong(2, valueVal.getId());
            callable.setLong(3, valueVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

