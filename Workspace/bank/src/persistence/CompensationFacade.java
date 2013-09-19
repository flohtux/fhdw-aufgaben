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
            Compensation result = new Compensation(null,null,null,null,null,id);
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
            Compensation result = new Compensation(null,null,null,null,null,id);
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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccount requestingAccount = null;
            PersistentCompensationPendingRequests pendingRequests = null;
            PersistentStornoState stornoState = null;
            SubjInterface subService = null;
            PersistentCompensation This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10358: {
                        requestingAccount = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10359: {
                        pendingRequests = (PersistentCompensationPendingRequests)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10393: {
                        stornoState = (PersistentStornoState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10360: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10361: {
                        This = (PersistentCompensation)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            Compensation result = new Compensation(requestingAccount, 
                                                   pendingRequests, 
                                                   stornoState, 
                                                   subService, 
                                                   This, 
                                                   CompensationId);
            links.close();
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
    public void stornoStateSet(long CompensationId, PersistentStornoState stornoStateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnFacade.strnSttSet(?, ?, ?); end;");
            callable.setLong(1, CompensationId);
            callable.setLong(2, stornoStateVal.getId());
            callable.setLong(3, stornoStateVal.getClassId());
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
    public CompensationSearchList inverseGetStornoState(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnFacade.iGetStrnStt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            CompensationSearchList result = new CompensationSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentCompensation)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentCompensation)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

