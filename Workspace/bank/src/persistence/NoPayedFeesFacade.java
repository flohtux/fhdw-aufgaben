package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NoPayedFeesFacade{

	private String schemaName;
	private Connection con;

	public NoPayedFeesFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NoPayedFeesProxi getTheNoPayedFees() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NPdFsFacade.getTheNPdFs; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (NoPayedFeesProxi)PersistentProxi.createProxi(id, 287);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoPayedFees getNoPayedFees(long NoPayedFeesId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NPdFsFacade.getNPdFs(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NoPayedFeesId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMoney payedFees = null;
            if (obj.getLong(2) != 0)
                payedFees = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAccount payingAccount = null;
            if (obj.getLong(4) != 0)
                payingAccount = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentDebitTransferPayedFees This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentDebitTransferPayedFees)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            NoPayedFees result = new NoPayedFees(payedFees,
                                                 payingAccount,
                                                 subService,
                                                 This,
                                                 NoPayedFeesId);
            obj.close();
            callable.close();
            NoPayedFeesICProxi inCache = (NoPayedFeesICProxi)Cache.getTheCache().put(result);
            NoPayedFees objectInCache = (NoPayedFees)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

