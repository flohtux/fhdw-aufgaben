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
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            SubjInterface subService = null;
            PersistentRule This = null;
            String subject = "";
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10307: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10308: {
                        This = (PersistentRule)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10300: {
                        subject = links.getString(6);
                        if(subject == null)subject = "";
                        break;
                    }
                }
            }
            SubjectRule result = new SubjectRule(subService, 
                                                 This, 
                                                 subject, 
                                                 SubjectRuleId);
            links.close();
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

