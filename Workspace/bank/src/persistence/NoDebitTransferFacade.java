package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class NoDebitTransferFacade{

	private String schemaName;
	private Connection con;

	public NoDebitTransferFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public NoDebitTransferProxi newNoDebitTransfer(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NDbtTrnsfrFacade.newNDbtTrnsfr(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NoDebitTransfer result = new NoDebitTransfer(null,null,id);
            Cache.getTheCache().put(result);
            return (NoDebitTransferProxi)PersistentProxi.createProxi(id, 276);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoDebitTransferProxi newDelayedNoDebitTransfer() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".NDbtTrnsfrFacade.newDelayedNDbtTrnsfr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            NoDebitTransfer result = new NoDebitTransfer(null,null,id);
            Cache.getTheCache().put(result);
            return (NoDebitTransferProxi)PersistentProxi.createProxi(id, 276);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoDebitTransfer getNoDebitTransfer(long NoDebitTransferId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NDbtTrnsfrFacade.getNDbtTrnsfr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, NoDebitTransferId);
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
            PersistentNoDebitTransfer This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentNoDebitTransfer)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            NoDebitTransfer result = new NoDebitTransfer(subService,
                                                         This,
                                                         NoDebitTransferId);
            obj.close();
            callable.close();
            NoDebitTransferICProxi inCache = (NoDebitTransferICProxi)Cache.getTheCache().put(result);
            NoDebitTransfer objectInCache = (NoDebitTransfer)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NDbtTrnsfrFacade.getClass(?); end;");
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
    public void subServiceSet(long NoDebitTransferId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".NDbtTrnsfrFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, NoDebitTransferId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long NoDebitTransferId, PersistentNoDebitTransfer ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".NDbtTrnsfrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, NoDebitTransferId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

