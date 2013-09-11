package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DebitGrantListeFacade{

	private String schemaName;
	private Connection con;

	public DebitGrantListeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DebitGrantListeProxi newDebitGrantListe(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtGrntLstFacade.newDbtGrntLst(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitGrantListe result = new DebitGrantListe(null,null,id);
            Cache.getTheCache().put(result);
            return (DebitGrantListeProxi)PersistentProxi.createProxi(id, 202);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitGrantListeProxi newDelayedDebitGrantListe() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtGrntLstFacade.newDelayedDbtGrntLst(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitGrantListe result = new DebitGrantListe(null,null,id);
            Cache.getTheCache().put(result);
            return (DebitGrantListeProxi)PersistentProxi.createProxi(id, 202);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitGrantListe getDebitGrantListe(long DebitGrantListeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtGrntLstFacade.getDbtGrntLst(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitGrantListeId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentDebitGrantListe This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10205: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10206: {
                        This = (PersistentDebitGrantListe)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            DebitGrantListe result = new DebitGrantListe(subService, 
                                                         This, 
                                                         DebitGrantListeId);
            links.close();
            callable.close();
            DebitGrantListeICProxi inCache = (DebitGrantListeICProxi)Cache.getTheCache().put(result);
            DebitGrantListe objectInCache = (DebitGrantListe)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtGrntLstFacade.getClass(?); end;");
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
    public long debitGrantsAdd(long DebitGrantListeId, PersistentDebitGrant debitGrantsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtGrntLstFacade.dbtGrntsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, DebitGrantListeId);
            callable.setLong(3, debitGrantsVal.getId());
            callable.setLong(4, debitGrantsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void debitGrantsRem(long debitGrantsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtGrntLstFacade.dbtGrntsRem(?); end;");
            callable.setLong(1, debitGrantsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitGrantList debitGrantsGet(long DebitGrantListeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtGrntLstFacade.dbtGrntsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitGrantListeId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            DebitGrantList result = new DebitGrantList();
            while (list.next()) {
                result.add((PersistentDebitGrant)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long DebitGrantListeId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtGrntLstFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitGrantListeId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitGrantListeId, PersistentDebitGrantListe ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbtGrntLstFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitGrantListeId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

