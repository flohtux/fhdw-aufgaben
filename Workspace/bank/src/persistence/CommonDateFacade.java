package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CommonDateFacade{

	private String schemaName;
	private Connection con;

	public CommonDateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CommonDateProxi newCommonDate(java.sql.Date createDate,java.sql.Date commitDate,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmnDtFacade.newCmmnDt(?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setDate(2, createDate);
            callable.setDate(3, commitDate);
            callable.setLong(4, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CommonDate result = new CommonDate(createDate,commitDate,id);
            Cache.getTheCache().put(result);
            return (CommonDateProxi)PersistentProxi.createProxi(id, 111);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CommonDateProxi newDelayedCommonDate(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmnDtFacade.newDelayedCmmnDt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CommonDate result = new CommonDate(createDate,commitDate,id);
            Cache.getTheCache().put(result);
            return (CommonDateProxi)PersistentProxi.createProxi(id, 111);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CommonDate getCommonDate(long CommonDateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmnDtFacade.getCmmnDt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CommonDateId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            java.sql.Date createDate = new java.sql.Date(System.currentTimeMillis());
            java.sql.Date commitDate = new java.sql.Date(System.currentTimeMillis());
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10020: {
                        createDate = links.getDate(7);
                        break;
                    }
                    case 10021: {
                        commitDate = links.getDate(7);
                        break;
                    }
                }
            }
            CommonDate result = new CommonDate(createDate, 
                                               commitDate, 
                                               CommonDateId);
            links.close();
            callable.close();
            CommonDateICProxi inCache = (CommonDateICProxi)Cache.getTheCache().put(result);
            CommonDate objectInCache = (CommonDate)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmnDtFacade.getClass(?); end;");
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
    public void createDateSet(long CommonDateId, java.sql.Date createDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmmnDtFacade.crtdtSet(?, ?); end;");
            callable.setLong(1, CommonDateId);
            callable.setDate(2, createDateVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commitDateSet(long CommonDateId, java.sql.Date commitDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmmnDtFacade.cmmtdtSet(?, ?); end;");
            callable.setLong(1, CommonDateId);
            callable.setDate(2, commitDateVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

