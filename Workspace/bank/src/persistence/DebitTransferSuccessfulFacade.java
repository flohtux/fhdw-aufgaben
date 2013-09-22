package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DebitTransferSuccessfulFacade{

	private String schemaName;
	private Connection con;

	public DebitTransferSuccessfulFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DebitTransferSuccessfulProxi newDebitTransferSuccessful(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtTrnSuccFacade.newDbtTrnSucc(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitTransferSuccessful result = new DebitTransferSuccessful(null,null,id);
            Cache.getTheCache().put(result);
            return (DebitTransferSuccessfulProxi)PersistentProxi.createProxi(id, 197);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitTransferSuccessfulProxi newDelayedDebitTransferSuccessful() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtTrnSuccFacade.newDelayedDbtTrnSucc(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitTransferSuccessful result = new DebitTransferSuccessful(null,null,id);
            Cache.getTheCache().put(result);
            return (DebitTransferSuccessfulProxi)PersistentProxi.createProxi(id, 197);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitTransferSuccessful getDebitTransferSuccessful(long DebitTransferSuccessfulId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtTrnSuccFacade.getDbtTrnSucc(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitTransferSuccessfulId);
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
            PersistentDebitTransferSuccessful This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentDebitTransferSuccessful)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            DebitTransferSuccessful result = new DebitTransferSuccessful(subService,
                                                                         This,
                                                                         DebitTransferSuccessfulId);
            obj.close();
            callable.close();
            DebitTransferSuccessfulICProxi inCache = (DebitTransferSuccessfulICProxi)Cache.getTheCache().put(result);
            DebitTransferSuccessful objectInCache = (DebitTransferSuccessful)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtTrnSuccFacade.getClass(?); end;");
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
    public long successfulsAdd(long DebitTransferSuccessfulId, PersistentDebitTransferTransaction successfulsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtTrnSuccFacade.sccssflsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, DebitTransferSuccessfulId);
            callable.setLong(3, successfulsVal.getId());
            callable.setLong(4, successfulsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void successfulsRem(long successfulsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnSuccFacade.sccssflsRem(?); end;");
            callable.setLong(1, successfulsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferTransactionList successfulsGet(long DebitTransferSuccessfulId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtTrnSuccFacade.sccssflsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitTransferSuccessfulId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitTransferTransactionList result = new DebitTransferTransactionList();
            while (list.next()) {
                result.add((PersistentDebitTransferTransaction)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long DebitTransferSuccessfulId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnSuccFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferSuccessfulId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitTransferSuccessfulId, PersistentDebitTransferSuccessful ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtTrnSuccFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferSuccessfulId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

