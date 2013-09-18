package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompensationRequestStateFacade{

	private String schemaName;
	private Connection con;

	public CompensationRequestStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompensationRequestStateProxi newCompensationRequestState(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpReqStFacade.newCmpReqSt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationRequestState result = new CompensationRequestState(null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationRequestStateProxi)PersistentProxi.createProxi(id, 264);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationRequestStateProxi newDelayedCompensationRequestState() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpReqStFacade.newDelayedCmpReqSt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationRequestState result = new CompensationRequestState(null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationRequestStateProxi)PersistentProxi.createProxi(id, 264);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationRequestState getCompensationRequestState(long CompensationRequestStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpReqStFacade.getCmpReqSt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensationRequestStateId);
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
            PersistentCompensationRequestState This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentCompensationRequestState)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            CompensationRequestState result = new CompensationRequestState(subService,
                                                                           This,
                                                                           CompensationRequestStateId);
            obj.close();
            callable.close();
            CompensationRequestStateICProxi inCache = (CompensationRequestStateICProxi)Cache.getTheCache().put(result);
            CompensationRequestState objectInCache = (CompensationRequestState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpReqStFacade.getClass(?); end;");
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
    public void subServiceSet(long CompensationRequestStateId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpReqStFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestStateId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long CompensationRequestStateId, PersistentCompensationRequestState ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpReqStFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestStateId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

