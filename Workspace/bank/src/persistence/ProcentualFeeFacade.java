package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class ProcentualFeeFacade{

	private String schemaName;
	private Connection con;

	public ProcentualFeeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ProcentualFeeProxi newProcentualFee(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrcntlFFacade.newPrcntlF(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ProcentualFee result = new ProcentualFee(null,null,null,id);
            Cache.getTheCache().put(result);
            return (ProcentualFeeProxi)PersistentProxi.createProxi(id, 120);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ProcentualFeeProxi newDelayedProcentualFee() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrcntlFFacade.newDelayedPrcntlF(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ProcentualFee result = new ProcentualFee(null,null,null,id);
            Cache.getTheCache().put(result);
            return (ProcentualFeeProxi)PersistentProxi.createProxi(id, 120);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ProcentualFee getProcentualFee(long ProcentualFeeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrcntlFFacade.getPrcntlF(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ProcentualFeeId);
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
            PersistentPercent percent = null;
            if (obj.getLong(6) != 0)
                percent = (PersistentPercent)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            ProcentualFee result = new ProcentualFee(subService,
                                                     This,
                                                     percent,
                                                     ProcentualFeeId);
            obj.close();
            callable.close();
            ProcentualFeeICProxi inCache = (ProcentualFeeICProxi)Cache.getTheCache().put(result);
            ProcentualFee objectInCache = (ProcentualFee)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void percentSet(long ProcentualFeeId, PersistentPercent percentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrcntlFFacade.prcntSet(?, ?, ?); end;");
            callable.setLong(1, ProcentualFeeId);
            callable.setLong(2, percentVal.getId());
            callable.setLong(3, percentVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

