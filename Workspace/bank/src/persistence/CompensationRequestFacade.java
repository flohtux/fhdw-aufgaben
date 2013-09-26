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
            CompensationRequest result = new CompensationRequest(null,null,null,null,null,null,id);
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
            CompensationRequest result = new CompensationRequest(null,null,null,null,null,null,id);
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
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentDebitTransfer debitTransfer = null;
            if (obj.getLong(2) != 0)
                debitTransfer = (PersistentDebitTransfer)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAccount hasToAnswer = null;
            if (obj.getLong(4) != 0)
                hasToAnswer = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentCompensation masterCompensation = null;
            if (obj.getLong(6) != 0)
                masterCompensation = (PersistentCompensation)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentCompensationRequestState state = null;
            if (obj.getLong(8) != 0)
                state = (PersistentCompensationRequestState)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            SubjInterface subService = null;
            if (obj.getLong(10) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            PersistentCompensationRequest This = null;
            if (obj.getLong(12) != 0)
                This = (PersistentCompensationRequest)PersistentProxi.createProxi(obj.getLong(12), obj.getLong(13));
            CompensationRequest result = new CompensationRequest(debitTransfer,
                                                                 hasToAnswer,
                                                                 masterCompensation,
                                                                 state,
                                                                 subService,
                                                                 This,
                                                                 CompensationRequestId);
            obj.close();
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
    public void debitTransferSet(long CompensationRequestId, PersistentDebitTransfer debitTransferVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnRqstFacade.dbtTrnsfrSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestId);
            callable.setLong(2, debitTransferVal.getId());
            callable.setLong(3, debitTransferVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void hasToAnswerSet(long CompensationRequestId, PersistentAccount hasToAnswerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnstnRqstFacade.hsTAnswrSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestId);
            callable.setLong(2, hasToAnswerVal.getId());
            callable.setLong(3, hasToAnswerVal.getClassId());
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

