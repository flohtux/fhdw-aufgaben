package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompensationFacade{

	private String schemaName;
	private Connection con;

	public CompensationFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompensationProxi newCompensation(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnFacade.newCmpnstn(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Compensation result = new Compensation(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationProxi)PersistentProxi.createProxi(id, 254);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationProxi newDelayedCompensation() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnFacade.newDelayedCmpnstn(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Compensation result = new Compensation(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationProxi)PersistentProxi.createProxi(id, 254);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Compensation getCompensation(long CompensationId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnFacade.getCmpnstn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensationId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentAccount requestingAccount = null;
            if (obj.getLong(2) != 0)
                requestingAccount = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentCompensationPendingRequests pendingRequests = null;
            if (obj.getLong(4) != 0)
                pendingRequests = (PersistentCompensationPendingRequests)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCompensation This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentCompensation)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            Compensation result = new Compensation(requestingAccount,
                                                   pendingRequests,
                                                   subService,
                                                   This,
                                                   CompensationId);
            obj.close();
            callable.close();
            CompensationICProxi inCache = (CompensationICProxi)Cache.getTheCache().put(result);
            Compensation objectInCache = (Compensation)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnFacade.getClass(?); end;");
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
    public long transactionsToBeCompensatedAdd(long CompensationId, PersistentDebitTransferTransaction transactionsToBeCompensatedVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnFacade.2beCmpstdAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CompensationId);
            callable.setLong(3, transactionsToBeCompensatedVal.getId());
            callable.setLong(4, transactionsToBeCompensatedVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void transactionsToBeCompensatedRem(long transactionsToBeCompensatedId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnFacade.2beCmpstdRem(?); end;");
            callable.setLong(1, transactionsToBeCompensatedId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferTransactionList transactionsToBeCompensatedGet(long CompensationId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnFacade.2beCmpstdGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensationId);
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
    public void requestingAccountSet(long CompensationId, PersistentAccount requestingAccountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnFacade.rqstngAccntSet(?, ?, ?); end;");
            callable.setLong(1, CompensationId);
            callable.setLong(2, requestingAccountVal.getId());
            callable.setLong(3, requestingAccountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void pendingRequestsSet(long CompensationId, PersistentCompensationPendingRequests pendingRequestsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnFacade.pndngRqstsSet(?, ?, ?); end;");
            callable.setLong(1, CompensationId);
            callable.setLong(2, pendingRequestsVal.getId());
            callable.setLong(3, pendingRequestsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long CompensationId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, CompensationId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long CompensationId, PersistentCompensation ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, CompensationId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

