package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DebitTransferTemplateFacade{

	private String schemaName;
	private Connection con;

	public DebitTransferTemplateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DebitTransferTemplateProxi newDebitTransferTemplate(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtTmplFacade.newDbTrNtTmpl(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitTransferTemplate result = new DebitTransferTemplate(null,null,id);
            Cache.getTheCache().put(result);
            return (DebitTransferTemplateProxi)PersistentProxi.createProxi(id, 208);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitTransferTemplateProxi newDelayedDebitTransferTemplate() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtTmplFacade.newDelayedDbTrNtTmpl(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitTransferTemplate result = new DebitTransferTemplate(null,null,id);
            Cache.getTheCache().put(result);
            return (DebitTransferTemplateProxi)PersistentProxi.createProxi(id, 208);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitTransferTemplate getDebitTransferTemplate(long DebitTransferTemplateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtTmplFacade.getDbTrNtTmpl(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitTransferTemplateId);
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
            PersistentDebitTransferTemplate This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentDebitTransferTemplate)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            DebitTransferTemplate result = new DebitTransferTemplate(subService,
                                                                     This,
                                                                     DebitTransferTemplateId);
            obj.close();
            callable.close();
            DebitTransferTemplateICProxi inCache = (DebitTransferTemplateICProxi)Cache.getTheCache().put(result);
            DebitTransferTemplate objectInCache = (DebitTransferTemplate)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtTmplFacade.getClass(?); end;");
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
    public long templatesAdd(long DebitTransferTemplateId, PersistentDebitTransferTransaction templatesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtTmplFacade.tmpltsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, DebitTransferTemplateId);
            callable.setLong(3, templatesVal.getId());
            callable.setLong(4, templatesVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void templatesRem(long templatesId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbTrNtTmplFacade.tmpltsRem(?); end;");
            callable.setLong(1, templatesId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public DebitTransferTransactionList templatesGet(long DebitTransferTemplateId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbTrNtTmplFacade.tmpltsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitTransferTemplateId);
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
    public void subServiceSet(long DebitTransferTemplateId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbTrNtTmplFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferTemplateId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitTransferTemplateId, PersistentDebitTransferTemplate ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DbTrNtTmplFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferTemplateId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

