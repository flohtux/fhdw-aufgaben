package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DollarFacade{

	private String schemaName;
	private Connection con;

	public DollarFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DollarProxi getTheDollar() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DllrFacade.getTheDllr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (DollarProxi)PersistentProxi.createProxi(id, 126);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Dollar getDollar(long DollarId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DllrFacade.getDllr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DollarId);
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
            PersistentCurrency This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentCurrency)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Dollar result = new Dollar(subService,
                                       This,
                                       DollarId);
            obj.close();
            callable.close();
            DollarICProxi inCache = (DollarICProxi)Cache.getTheCache().put(result);
            Dollar objectInCache = (Dollar)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

