package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DebitTransferDoubleStateFacade{

	private String schemaName;
	private Connection con;

	public DebitTransferDoubleStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DebitTransferDoubleStateProxi newDebitTransferDoubleState(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DebTraStaDoFacade.newDebTraStaDo(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitTransferDoubleState result = new DebitTransferDoubleState(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (DebitTransferDoubleStateProxi)PersistentProxi.createProxi(id, 228);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitTransferDoubleStateProxi newDelayedDebitTransferDoubleState() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DebTraStaDoFacade.newDelayedDebTraStaDo(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitTransferDoubleState result = new DebitTransferDoubleState(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (DebitTransferDoubleStateProxi)PersistentProxi.createProxi(id, 228);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitTransferDoubleState getDebitTransferDoubleState(long DebitTransferDoubleStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DebTraStaDoFacade.getDebTraStaDo(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitTransferDoubleStateId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentDebitTransferState debitTransferStateOld = null;
            PersistentDebitTransferState debitTransferStateNew = null;
            SubjInterface subService = null;
            PersistentDebitTransferDoubleState This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10295: {
                        debitTransferStateOld = (PersistentDebitTransferState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10296: {
                        debitTransferStateNew = (PersistentDebitTransferState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10293: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10294: {
                        This = (PersistentDebitTransferDoubleState)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            DebitTransferDoubleState result = new DebitTransferDoubleState(debitTransferStateOld, 
                                                                           debitTransferStateNew, 
                                                                           subService, 
                                                                           This, 
                                                                           DebitTransferDoubleStateId);
            links.close();
            callable.close();
            DebitTransferDoubleStateICProxi inCache = (DebitTransferDoubleStateICProxi)Cache.getTheCache().put(result);
            DebitTransferDoubleState objectInCache = (DebitTransferDoubleState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DebTraStaDoFacade.getClass(?); end;");
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
    public void debitTransferStateOldSet(long DebitTransferDoubleStateId, PersistentDebitTransferState debitTransferStateOldVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebTraStaDoFacade.dbtrstoldSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferDoubleStateId);
            callable.setLong(2, debitTransferStateOldVal.getId());
            callable.setLong(3, debitTransferStateOldVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void debitTransferStateNewSet(long DebitTransferDoubleStateId, PersistentDebitTransferState debitTransferStateNewVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebTraStaDoFacade.dbtrstNewSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferDoubleStateId);
            callable.setLong(2, debitTransferStateNewVal.getId());
            callable.setLong(3, debitTransferStateNewVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long DebitTransferDoubleStateId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebTraStaDoFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferDoubleStateId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitTransferDoubleStateId, PersistentDebitTransferDoubleState ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DebTraStaDoFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferDoubleStateId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

