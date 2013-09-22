package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AllCompensationListeFacade{

	private String schemaName;
	private Connection con;

	public AllCompensationListeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AllCompensationListeProxi newAllCompensationListe(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstFacade.newAllCmpLst(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AllCompensationListe result = new AllCompensationListe(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AllCompensationListeProxi)PersistentProxi.createProxi(id, 261);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AllCompensationListeProxi newDelayedAllCompensationListe() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstFacade.newDelayedAllCmpLst(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AllCompensationListe result = new AllCompensationListe(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AllCompensationListeProxi)PersistentProxi.createProxi(id, 261);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AllCompensationListe getAllCompensationListe(long AllCompensationListeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstFacade.getAllCmpLst(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AllCompensationListeId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAllCompensationListeOutgoingCompensations outgoingCompensations = null;
            PersistentAllCompensationListePendingCompensationRequests pendingCompensationRequests = null;
            SubjInterface subService = null;
            PersistentAllCompensationListe This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10380: {
                        outgoingCompensations = (PersistentAllCompensationListeOutgoingCompensations)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10381: {
                        pendingCompensationRequests = (PersistentAllCompensationListePendingCompensationRequests)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10382: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10383: {
                        This = (PersistentAllCompensationListe)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            AllCompensationListe result = new AllCompensationListe(outgoingCompensations, 
                                                                   pendingCompensationRequests, 
                                                                   subService, 
                                                                   This, 
                                                                   AllCompensationListeId);
            links.close();
            callable.close();
            AllCompensationListeICProxi inCache = (AllCompensationListeICProxi)Cache.getTheCache().put(result);
            AllCompensationListe objectInCache = (AllCompensationListe)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstFacade.getClass(?); end;");
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
    public void outgoingCompensationsSet(long AllCompensationListeId, PersistentAllCompensationListeOutgoingCompensations outgoingCompensationsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AllCmpLstFacade.outgngCmpsSet(?, ?, ?); end;");
            callable.setLong(1, AllCompensationListeId);
            callable.setLong(2, outgoingCompensationsVal.getId());
            callable.setLong(3, outgoingCompensationsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void pendingCompensationRequestsSet(long AllCompensationListeId, PersistentAllCompensationListePendingCompensationRequests pendingCompensationRequestsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AllCmpLstFacade.pndgCmpSet(?, ?, ?); end;");
            callable.setLong(1, AllCompensationListeId);
            callable.setLong(2, pendingCompensationRequestsVal.getId());
            callable.setLong(3, pendingCompensationRequestsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long AllCompensationListeId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AllCmpLstFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, AllCompensationListeId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AllCompensationListeId, PersistentAllCompensationListe ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AllCmpLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AllCompensationListeId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

