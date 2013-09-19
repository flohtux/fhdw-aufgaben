package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompensationRequestFacade{

	private String schemaName;
	private Connection con;

	public CompensationRequestFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompensationRequestProxi newCompensationRequest(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnRqstFacade.newCmpnstnRqst(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationRequest result = new CompensationRequest(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationRequestProxi)PersistentProxi.createProxi(id, 256);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationRequestProxi newDelayedCompensationRequest() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnRqstFacade.newDelayedCmpnstnRqst(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationRequest result = new CompensationRequest(null,null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationRequestProxi)PersistentProxi.createProxi(id, 256);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationRequest getCompensationRequest(long CompensationRequestId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnRqstFacade.getCmpnstnRqst(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensationRequestId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentDebitTransferTransaction debitTransferTransaction = null;
            PersistentCompensation masterCompensation = null;
            PersistentCompensationRequestState state = null;
            SubjInterface subService = null;
            PersistentCompensationRequest This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10365: {
                        debitTransferTransaction = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10391: {
                        masterCompensation = (PersistentCompensation)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10388: {
                        state = (PersistentCompensationRequestState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10366: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10367: {
                        This = (PersistentCompensationRequest)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            CompensationRequest result = new CompensationRequest(debitTransferTransaction, 
                                                                 masterCompensation, 
                                                                 state, 
                                                                 subService, 
                                                                 This, 
                                                                 CompensationRequestId);
            links.close();
            callable.close();
            CompensationRequestICProxi inCache = (CompensationRequestICProxi)Cache.getTheCache().put(result);
            CompensationRequest objectInCache = (CompensationRequest)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnstnRqstFacade.getClass(?); end;");
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
    public void debitTransferTransactionSet(long CompensationRequestId, PersistentDebitTransferTransaction debitTransferTransactionVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnRqstFacade.cmpstDtTrSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestId);
            callable.setLong(2, debitTransferTransactionVal.getId());
            callable.setLong(3, debitTransferTransactionVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void masterCompensationSet(long CompensationRequestId, PersistentCompensation masterCompensationVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnRqstFacade.mstrCmpnstnSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestId);
            callable.setLong(2, masterCompensationVal.getId());
            callable.setLong(3, masterCompensationVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void stateSet(long CompensationRequestId, PersistentCompensationRequestState stateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnRqstFacade.sttSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestId);
            callable.setLong(2, stateVal.getId());
            callable.setLong(3, stateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long CompensationRequestId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnRqstFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long CompensationRequestId, PersistentCompensationRequest ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnRqstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

