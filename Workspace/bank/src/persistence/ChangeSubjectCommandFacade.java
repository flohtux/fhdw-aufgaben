package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class ChangeSubjectCommandFacade{

	private String schemaName;
	private Connection con;

	public ChangeSubjectCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ChangeSubjectCommandProxi newChangeSubjectCommand(String subject,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngSbjctCMDFacade.newChngSbjctCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, subject);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeSubjectCommand result = new ChangeSubjectCommand(null,subject,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ChangeSubjectCommandProxi)PersistentProxi.createProxi(id, 253);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeSubjectCommandProxi newDelayedChangeSubjectCommand(String subject) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngSbjctCMDFacade.newDelayedChngSbjctCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ChangeSubjectCommand result = new ChangeSubjectCommand(null,subject,null,null,null,id);
            Cache.getTheCache().put(result);
            return (ChangeSubjectCommandProxi)PersistentProxi.createProxi(id, 253);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ChangeSubjectCommand getChangeSubjectCommand(long ChangeSubjectCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngSbjctCMDFacade.getChngSbjctCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ChangeSubjectCommandId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentDebitTransfer trans = null;
            String subject = "";
            Invoker invoker = null;
            PersistentAccount commandReceiver = null;
            PersistentCommonDate myCommonDate = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10352: {
                        trans = (PersistentDebitTransfer)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10353: {
                        subject = links.getString(6);
                        if(subject == null)subject = "";
                        break;
                    }
                    case 10354: {
                        invoker = (Invoker)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10355: {
                        commandReceiver = (PersistentAccount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10356: {
                        myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            ChangeSubjectCommand result = new ChangeSubjectCommand(trans, 
                                                                   subject, 
                                                                   invoker, 
                                                                   commandReceiver, 
                                                                   myCommonDate, 
                                                                   ChangeSubjectCommandId);
            links.close();
            callable.close();
            ChangeSubjectCommandICProxi inCache = (ChangeSubjectCommandICProxi)Cache.getTheCache().put(result);
            ChangeSubjectCommand objectInCache = (ChangeSubjectCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ChngSbjctCMDFacade.getClass(?); end;");
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
    public void transSet(long ChangeSubjectCommandId, PersistentDebitTransfer transVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngSbjctCMDFacade.trnsSet(?, ?, ?); end;");
            callable.setLong(1, ChangeSubjectCommandId);
            callable.setLong(2, transVal.getId());
            callable.setLong(3, transVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subjectSet(long ChangeSubjectCommandId, String subjectVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngSbjctCMDFacade.sbjctSet(?, ?); end;");
            callable.setLong(1, ChangeSubjectCommandId);
            callable.setString(2, subjectVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ChangeSubjectCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngSbjctCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ChangeSubjectCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ChangeSubjectCommandId, PersistentAccount commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngSbjctCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ChangeSubjectCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ChangeSubjectCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ChngSbjctCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ChangeSubjectCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

