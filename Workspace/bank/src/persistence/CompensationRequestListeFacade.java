package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class CompensationRequestListeFacade{

	private String schemaName;
	private Connection con;

	public CompensationRequestListeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CompensationRequestListeProxi newCompensationRequestListe(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpRqLstFacade.newCmpRqLst(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationRequestListe result = new CompensationRequestListe(null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationRequestListeProxi)PersistentProxi.createProxi(id, 260);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationRequestListeProxi newDelayedCompensationRequestListe() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpRqLstFacade.newDelayedCmpRqLst(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CompensationRequestListe result = new CompensationRequestListe(null,null,id);
            Cache.getTheCache().put(result);
            return (CompensationRequestListeProxi)PersistentProxi.createProxi(id, 260);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CompensationRequestListe getCompensationRequestListe(long CompensationRequestListeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpRqLstFacade.getCmpRqLst(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensationRequestListeId);
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
            PersistentCompensationRequestListe This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentCompensationRequestListe)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            CompensationRequestListe result = new CompensationRequestListe(subService,
                                                                           This,
                                                                           CompensationRequestListeId);
            obj.close();
            callable.close();
            CompensationRequestListeICProxi inCache = (CompensationRequestListeICProxi)Cache.getTheCache().put(result);
            CompensationRequestListe objectInCache = (CompensationRequestListe)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpRqLstFacade.getClass(?); end;");
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
    public long compensationrequestsAdd(long CompensationRequestListeId, PersistentCompensationRequest compensationrequestsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpRqLstFacade.rqstsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, CompensationRequestListeId);
            callable.setLong(3, compensationrequestsVal.getId());
            callable.setLong(4, compensationrequestsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void compensationrequestsRem(long compensationrequestsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpRqLstFacade.rqstsRem(?); end;");
            callable.setLong(1, compensationrequestsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public CompensationRequestList compensationrequestsGet(long CompensationRequestListeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpRqLstFacade.rqstsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CompensationRequestListeId);
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
    public void subServiceSet(long CompensationRequestListeId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpRqLstFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestListeId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long CompensationRequestListeId, PersistentCompensationRequestListe ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpRqLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, CompensationRequestListeId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

