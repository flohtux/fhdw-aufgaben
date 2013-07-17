package persistence;

import model.meta.*;

import java.sql.*;
import oracle.jdbc.*;

public class AddComponentCommandFacade{

	private String schemaName;
	private Connection con;

	public AddComponentCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AddComponentCommandProxi newAddComponentCommand(long amount,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddCmpnntCMDFacade.newAddCmpnntCMD(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, amount);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddComponentCommand result = new AddComponentCommand(null,null,amount,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddComponentCommandProxi)PersistentProxi.createProxi(id, 110);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddComponentCommandProxi newDelayedAddComponentCommand(long amount) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AddCmpnntCMDFacade.newDelayedAddCmpnntCMD(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            AddComponentCommand result = new AddComponentCommand(null,null,amount,null,null,null,id);
            Cache.getTheCache().put(result);
            return (AddComponentCommandProxi)PersistentProxi.createProxi(id, 110);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AddComponentCommand getAddComponentCommand(long AddComponentCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddCmpnntCMDFacade.getAddCmpnntCMD(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AddComponentCommandId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentProduct product = null;
            if (obj.getLong(2) != 0)
                product = (PersistentProduct)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentComponent newPart = null;
            if (obj.getLong(4) != 0)
                newPart = (PersistentComponent)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            Invoker invoker = null;
            if (obj.getLong(7) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            PersistentPartsListManager commandReceiver = null;
            if (obj.getLong(9) != 0)
                commandReceiver = (PersistentPartsListManager)PersistentProxi.createProxi(obj.getLong(9), obj.getLong(10));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(11) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(11), obj.getLong(12));
            AddComponentCommand result = new AddComponentCommand(product,
                                                                 newPart,
                                                                 obj.getLong(6),
                                                                 invoker,
                                                                 commandReceiver,
                                                                 myCommonDate,
                                                                 AddComponentCommandId);
            obj.close();
            callable.close();
            AddComponentCommandICProxi inCache = (AddComponentCommandICProxi)Cache.getTheCache().put(result);
            AddComponentCommand objectInCache = (AddComponentCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AddCmpnntCMDFacade.getClass(?); end;");
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
    public void productSet(long AddComponentCommandId, PersistentProduct productVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddCmpnntCMDFacade.prdctSet(?, ?, ?); end;");
            callable.setLong(1, AddComponentCommandId);
            callable.setLong(2, productVal.getId());
            callable.setLong(3, productVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void newPartSet(long AddComponentCommandId, PersistentComponent newPartVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddCmpnntCMDFacade.nwPrtSet(?, ?, ?); end;");
            callable.setLong(1, AddComponentCommandId);
            callable.setLong(2, newPartVal.getId());
            callable.setLong(3, newPartVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void amountSet(long AddComponentCommandId, long amountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddCmpnntCMDFacade.amntSet(?, ?); end;");
            callable.setLong(1, AddComponentCommandId);
            callable.setLong(2, amountVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long AddComponentCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddCmpnntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, AddComponentCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long AddComponentCommandId, PersistentPartsListManager commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddCmpnntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, AddComponentCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long AddComponentCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AddCmpnntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, AddComponentCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

