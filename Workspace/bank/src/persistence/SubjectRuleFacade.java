package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class SubjectRuleFacade{

	private String schemaName;
	private Connection con;

	public SubjectRuleFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public SubjectRuleProxi newSubjectRule(String subject,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SbjctRlFacade.newSbjctRl(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, subject);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SubjectRule result = new SubjectRule(null,null,subject,id);
            Cache.getTheCache().put(result);
            return (SubjectRuleProxi)PersistentProxi.createProxi(id, 230);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SubjectRuleProxi newDelayedSubjectRule(String subject) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SbjctRlFacade.newDelayedSbjctRl(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            SubjectRule result = new SubjectRule(null,null,subject,id);
            Cache.getTheCache().put(result);
            return (SubjectRuleProxi)PersistentProxi.createProxi(id, 230);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SubjectRule getSubjectRule(long SubjectRuleId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SbjctRlFacade.getSbjctRl(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, SubjectRuleId);
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
            PersistentRule This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentRule)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjectRule result = new SubjectRule(subService,
                                                 This,
                                                 obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                                 SubjectRuleId);
            obj.close();
            callable.close();
            SubjectRuleICProxi inCache = (SubjectRuleICProxi)Cache.getTheCache().put(result);
            SubjectRule objectInCache = (SubjectRule)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subjectSet(long SubjectRuleId, String subjectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SbjctRlFacade.sbjctSet(?, ?); end;");
            callable.setLong(1, SubjectRuleId);
            callable.setString(2, subjectVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

