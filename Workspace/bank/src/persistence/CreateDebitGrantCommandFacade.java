package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class CreateDebitGrantCommandFacade{

	private String schemaName;
	private Connection con;

	public CreateDebitGrantCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public CreateDebitGrantCommandProxi newCreateDebitGrantCommand(long receiverBankNumber,long receiverAccNumber,String limitType,common.Fraction amount,String cur,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtDbtGrntCMDFacade.newCrtDbtGrntCMD(?,?,?,?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, receiverBankNumber);
            callable.setLong(3, receiverAccNumber);
            callable.setString(4, limitType);
            callable.setString(5, amount.toString());
            callable.setString(6, cur);
            callable.setLong(7, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateDebitGrantCommand result = new CreateDebitGrantCommand(null,receiverBankNumber,receiverAccNumber,limitType,amount,cur,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateDebitGrantCommandProxi)PersistentProxi.createProxi(id, 198);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateDebitGrantCommandProxi newDelayedCreateDebitGrantCommand(long receiverBankNumber,long receiverAccNumber,String limitType,common.Fraction amount,String cur) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtDbtGrntCMDFacade.newDelayedCrtDbtGrntCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CreateDebitGrantCommand result = new CreateDebitGrantCommand(null,receiverBankNumber,receiverAccNumber,limitType,amount,cur,null,null,null,id);
            Cache.getTheCache().put(result);
            return (CreateDebitGrantCommandProxi)PersistentProxi.createProxi(id, 198);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CreateDebitGrantCommand getCreateDebitGrantCommand(long CreateDebitGrantCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtDbtGrntCMDFacade.getCrtDbtGrntCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, CreateDebitGrantCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentDebitGrantListe debitGrantList = null;
            if (obj.getLong(2) != 0)
                debitGrantList = (PersistentDebitGrantListe)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Invoker invoker = null;
            if (obj.getLong(9) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentAccountService commandReceiver = null;
            if (obj.getLong(11) != 0)
                commandReceiver = (PersistentAccountService)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(13) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(13), obj.getLong(14));
            CreateDebitGrantCommand result = new CreateDebitGrantCommand(debitGrantList,
                                                                         obj.getLong(4),
                                                                         obj.getLong(5),
                                                                         obj.getString(6) == null ? "" : obj.getString(6) /* In Oracle "" = null !!! */,
                                                                         common.Fraction.parse(obj.getString(7)),
                                                                         obj.getString(8) == null ? "" : obj.getString(8) /* In Oracle "" = null !!! */,
                                                                         invoker,
                                                                         commandReceiver,
                                                                         myCommonDate,
                                                                         CreateDebitGrantCommandId);
            obj.close();
            callable.close();
            CreateDebitGrantCommandICProxi inCache = (CreateDebitGrantCommandICProxi)Cache.getTheCache().put(result);
            CreateDebitGrantCommand objectInCache = (CreateDebitGrantCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CrtDbtGrntCMDFacade.getClass(?); end;");
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
    public void debitGrantListSet(long CreateDebitGrantCommandId, PersistentDebitGrantListe debitGrantListVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.dbtGrntLstSet(?, ?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, debitGrantListVal.getId());
            callable.setLong(3, debitGrantListVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void receiverBankNumberSet(long CreateDebitGrantCommandId, long receiverBankNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.rcvrBnkNmbrSet(?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, receiverBankNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void receiverAccNumberSet(long CreateDebitGrantCommandId, long receiverAccNumberVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.rcvrAccNmbrSet(?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, receiverAccNumberVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void limitTypeSet(long CreateDebitGrantCommandId, String limitTypeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.lmtTpSet(?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setString(2, limitTypeVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void amountSet(long CreateDebitGrantCommandId, common.Fraction amountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.amntSet(?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setString(2, amountVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void curSet(long CreateDebitGrantCommandId, String curVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.crSet(?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setString(2, curVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long CreateDebitGrantCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long CreateDebitGrantCommandId, PersistentAccountService commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long CreateDebitGrantCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CrtDbtGrntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, CreateDebitGrantCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

