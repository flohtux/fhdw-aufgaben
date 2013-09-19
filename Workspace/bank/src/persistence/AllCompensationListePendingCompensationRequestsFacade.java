package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AllCompensationListePendingCompensationRequestsFacade{

	private String schemaName;
	private Connection con;

	public AllCompensationListePendingCompensationRequestsFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AllCompensationListePendingCompensationRequestsProxi newAllCompensationListePendingCompensationRequests(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstPndgCmpFacade.newAllCmpLstPndgCmp(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AllCompensationListePendingCompensationRequests result = new AllCompensationListePendingCompensationRequests(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AllCompensationListePendingCompensationRequestsProxi)PersistentProxi.createProxi(id, 270);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AllCompensationListePendingCompensationRequestsProxi newDelayedAllCompensationListePendingCompensationRequests() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstPndgCmpFacade.newDelayedAllCmpLstPndgCmp(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AllCompensationListePendingCompensationRequests result = new AllCompensationListePendingCompensationRequests(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AllCompensationListePendingCompensationRequestsProxi)PersistentProxi.createProxi(id, 270);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AllCompensationListePendingCompensationRequests getAllCompensationListePendingCompensationRequests(long AllCompensationListePendingCompensationRequestsId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstPndgCmpFacade.getAllCmpLstPndgCmp(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AllCompensationListePendingCompensationRequestsId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAllCompensationListe observer = null;
            PersistentCompensationRequestListe observee = null;
            PersistentAllCompensationListePendingCompensationRequests This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10403: {
                        observer = (PersistentAllCompensationListe)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10404: {
                        observee = (PersistentCompensationRequestListe)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10405: {
                        This = (PersistentAllCompensationListePendingCompensationRequests)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            AllCompensationListePendingCompensationRequests result = new AllCompensationListePendingCompensationRequests(observer, 
                                                                                                                         observee, 
                                                                                                                         This, 
                                                                                                                         AllCompensationListePendingCompensationRequestsId);
            links.close();
            callable.close();
            AllCompensationListePendingCompensationRequestsICProxi inCache = (AllCompensationListePendingCompensationRequestsICProxi)Cache.getTheCache().put(result);
            AllCompensationListePendingCompensationRequests objectInCache = (AllCompensationListePendingCompensationRequests)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AllCmpLstPndgCmpFacade.getClass(?); end;");
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
    public void observerSet(long AllCompensationListePendingCompensationRequestsId, PersistentAllCompensationListe observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AllCmpLstPndgCmpFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AllCompensationListePendingCompensationRequestsId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AllCompensationListePendingCompensationRequestsId, PersistentCompensationRequestListe observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AllCmpLstPndgCmpFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AllCompensationListePendingCompensationRequestsId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AllCompensationListePendingCompensationRequestsId, PersistentAllCompensationListePendingCompensationRequests ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AllCmpLstPndgCmpFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AllCompensationListePendingCompensationRequestsId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

