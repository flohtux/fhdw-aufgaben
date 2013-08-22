package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DebitTransferNotExecutedFacade{

	private String schemaName;
	private Connection con;

	public DebitTransferNotExecutedFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DebitTransferNotExecutedProxi newDebitTransferNotExecuted(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtExecFacade.newDbTrNtExec(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitTransferNotExecuted result = new DebitTransferNotExecuted(null,null,id);
            Cache.getTheCache().put(result);
            return (DebitTransferNotExecutedProxi)PersistentProxi.createProxi(id, 200);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitTransferNotExecutedProxi newDelayedDebitTransferNotExecuted() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtExecFacade.newDelayedDbTrNtExec(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitTransferNotExecuted result = new DebitTransferNotExecuted(null,null,id);
            Cache.getTheCache().put(result);
            return (DebitTransferNotExecutedProxi)PersistentProxi.createProxi(id, 200);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitTransferNotExecuted getDebitTransferNotExecuted(long DebitTransferNotExecutedId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtExecFacade.getDbTrNtExec(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitTransferNotExecutedId);
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
            PersistentDebitTransferNotExecuted This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentDebitTransferNotExecuted)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            DebitTransferNotExecuted result = new DebitTransferNotExecuted(subService,
                                                                           This,
                                                                           DebitTransferNotExecutedId);
            obj.close();
            callable.close();
            DebitTransferNotExecutedICProxi inCache = (DebitTransferNotExecutedICProxi)Cache.getTheCache().put(result);
            DebitTransferNotExecuted objectInCache = (DebitTransferNotExecuted)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtExecFacade.getClass(?); end;");
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
    public long notExecutedsAdd(long DebitTransferNotExecutedId, PersistentDebitTransfer notExecutedsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtExecFacade.ntExctdsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, DebitTransferNotExecutedId);
            callable.setLong(3, notExecutedsVal.getId());
            callable.setLong(4, notExecutedsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void notExecutedsRem(long notExecutedsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbTrNtExecFacade.ntExctdsRem(?); end;");
            callable.setLong(1, notExecutedsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferList notExecutedsGet(long DebitTransferNotExecutedId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtExecFacade.ntExctdsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitTransferNotExecutedId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitTransferList result = new DebitTransferList();
            while (list.next()) {
                result.add((PersistentDebitTransfer)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long DebitTransferNotExecutedId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbTrNtExecFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferNotExecutedId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitTransferNotExecutedId, PersistentDebitTransferNotExecuted ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbTrNtExecFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferNotExecutedId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

