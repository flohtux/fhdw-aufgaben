package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompensationPendingRequestsFacade{

	private String schemaName;
	private Connection con;

	public CompensationPendingRequestsFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompensationPendingRequestsProxi newCompensationPendingRequests(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnPndngRqstsFacade.newCmpnstnPndngRqsts(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationPendingRequests result = new CompensationPendingRequests(null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationPendingRequestsProxi)PersistentProxi.createProxi(id, 257);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationPendingRequestsProxi newDelayedCompensationPendingRequests() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnPndngRqstsFacade.newDelayedCmpnstnPndngRqsts(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationPendingRequests result = new CompensationPendingRequests(null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationPendingRequestsProxi)PersistentProxi.createProxi(id, 257);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationPendingRequests getCompensationPendingRequests(long CompensationPendingRequestsId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnPndngRqstsFacade.getCmpnstnPndngRqsts(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensationPendingRequestsId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentCompensation observer = null;
            if (obj.getLong(2) != 0)
                observer = (PersistentCompensation)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentCompensationPendingRequests This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentCompensationPendingRequests)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            CompensationPendingRequests result = new CompensationPendingRequests(observer,
                                                                                 This,
                                                                                 CompensationPendingRequestsId);
            obj.close();
            callable.close();
            CompensationPendingRequestsICProxi inCache = (CompensationPendingRequestsICProxi)Cache.getTheCache().put(result);
            CompensationPendingRequests objectInCache = (CompensationPendingRequests)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnPndngRqstsFacade.getClass(?); end;");
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
    public void observerSet(long CompensationPendingRequestsId, PersistentCompensation observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnPndngRqstsFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, CompensationPendingRequestsId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long observeeAdd(long CompensationPendingRequestsId, PersistentCompensationRequest observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnPndngRqstsFacade.obsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CompensationPendingRequestsId);
            callable.setLong(3, observeeVal.getId());
            callable.setLong(4, observeeVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeRem(long observeeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnPndngRqstsFacade.obsRem(?); end;");
            callable.setLong(1, observeeId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public CompensationRequestList observeeGet(long CompensationPendingRequestsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnPndngRqstsFacade.obsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensationPendingRequestsId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            CompensationRequestList result = new CompensationRequestList();
            while (list.next()) {
                result.add((PersistentCompensationRequest)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long CompensationPendingRequestsId, PersistentCompensationPendingRequests ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnPndngRqstsFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, CompensationPendingRequestsId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

