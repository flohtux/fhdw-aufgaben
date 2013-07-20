package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class TransactionFacade{

	private String schemaName;
	private Connection con;

	public TransactionFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public TransactionProxi newTransaction(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.newTrnsctn(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transaction result = new Transaction(null,null,id);
            Cache.getTheCache().put(result);
            return (TransactionProxi)PersistentProxi.createProxi(id, 146);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TransactionProxi newDelayedTransaction() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.newDelayedTrnsctn(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transaction result = new Transaction(null,null,id);
            Cache.getTheCache().put(result);
            return (TransactionProxi)PersistentProxi.createProxi(id, 146);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Transaction getTransaction(long TransactionId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsctnFacade.getTrnsctn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, TransactionId);
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
            PersistentDebitNoteTransferTransaction This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentDebitNoteTransferTransaction)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Transaction result = new Transaction(subService,
                                                 This,
                                                 TransactionId);
            obj.close();
            callable.close();
            TransactionICProxi inCache = (TransactionICProxi)Cache.getTheCache().put(result);
            Transaction objectInCache = (Transaction)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

