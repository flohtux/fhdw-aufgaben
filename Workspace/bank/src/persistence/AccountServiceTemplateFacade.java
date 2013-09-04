package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AccountServiceTemplateFacade{

	private String schemaName;
	private Connection con;

	public AccountServiceTemplateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AccountServiceTemplateProxi newAccountServiceTemplate(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcTmpltFacade.newAccntSrvcTmplt(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceTemplate result = new AccountServiceTemplate(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceTemplateProxi)PersistentProxi.createProxi(id, 222);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceTemplateProxi newDelayedAccountServiceTemplate() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcTmpltFacade.newDelayedAccntSrvcTmplt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AccountServiceTemplate result = new AccountServiceTemplate(null,null,null,id);
            Cache.getTheCache().put(result);
            return (AccountServiceTemplateProxi)PersistentProxi.createProxi(id, 222);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AccountServiceTemplate getAccountServiceTemplate(long AccountServiceTemplateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcTmpltFacade.getAccntSrvcTmplt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AccountServiceTemplateId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentAccountService observer = null;
            PersistentDebitTransferTemplate observee = null;
            PersistentAccountServiceTemplate This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10273: {
                        observer = (PersistentAccountService)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10274: {
                        observee = (PersistentDebitTransferTemplate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10275: {
                        This = (PersistentAccountServiceTemplate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            AccountServiceTemplate result = new AccountServiceTemplate(observer, 
                                                                       observee, 
                                                                       This, 
                                                                       AccountServiceTemplateId);
            links.close();
            callable.close();
            AccountServiceTemplateICProxi inCache = (AccountServiceTemplateICProxi)Cache.getTheCache().put(result);
            AccountServiceTemplate objectInCache = (AccountServiceTemplate)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AccntSrvcTmpltFacade.getClass(?); end;");
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
    public void observerSet(long AccountServiceTemplateId, PersistentAccountService observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcTmpltFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceTemplateId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeSet(long AccountServiceTemplateId, PersistentDebitTransferTemplate observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcTmpltFacade.obsSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceTemplateId);
            callable.setLong(2, observeeVal.getId());
            callable.setLong(3, observeeVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AccountServiceTemplateId, PersistentAccountServiceTemplate ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AccntSrvcTmpltFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AccountServiceTemplateId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

