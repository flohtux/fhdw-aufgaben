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

    public ProcentualFeeProxi getTheProcentualFee() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrcntlFFacade.getThePrcntlF; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (ProcentualFeeProxi)PersistentProxi.createProxi(id, 148);
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
            ProcentualFee result = new ProcentualFee(subService,
                                                     This,
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

}

