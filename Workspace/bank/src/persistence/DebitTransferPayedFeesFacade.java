package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class DebitTransferPayedFeesFacade{

	private String schemaName;
	private Connection con;

	public DebitTransferPayedFeesFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public DebitTransferPayedFeesProxi newDebitTransferPayedFees(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".dtrpaydfsFacade.newdtrpaydfs(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitTransferPayedFees result = new DebitTransferPayedFees(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (DebitTransferPayedFeesProxi)PersistentProxi.createProxi(id, 288);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitTransferPayedFeesProxi newDelayedDebitTransferPayedFees() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".dtrpaydfsFacade.newDelayeddtrpaydfs(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            DebitTransferPayedFees result = new DebitTransferPayedFees(null,null,null,null,id);
            Cache.getTheCache().put(result);
            return (DebitTransferPayedFeesProxi)PersistentProxi.createProxi(id, 288);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public DebitTransferPayedFees getDebitTransferPayedFees(long DebitTransferPayedFeesId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".dtrpaydfsFacade.getdtrpaydfs(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, DebitTransferPayedFeesId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMoney payedFees = null;
            if (obj.getLong(2) != 0)
                payedFees = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAccount payingAccount = null;
            if (obj.getLong(4) != 0)
                payingAccount = (PersistentAccount)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentDebitTransferPayedFees This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentDebitTransferPayedFees)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            DebitTransferPayedFees result = new DebitTransferPayedFees(payedFees,
                                                                       payingAccount,
                                                                       subService,
                                                                       This,
                                                                       DebitTransferPayedFeesId);
            obj.close();
            callable.close();
            DebitTransferPayedFeesICProxi inCache = (DebitTransferPayedFeesICProxi)Cache.getTheCache().put(result);
            DebitTransferPayedFees objectInCache = (DebitTransferPayedFees)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".dtrpaydfsFacade.getClass(?); end;");
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
    public void payedFeesSet(long DebitTransferPayedFeesId, PersistentMoney payedFeesVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".dtrpaydfsFacade.pdFsSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferPayedFeesId);
            callable.setLong(2, payedFeesVal.getId());
            callable.setLong(3, payedFeesVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void payingAccountSet(long DebitTransferPayedFeesId, PersistentAccount payingAccountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".dtrpaydfsFacade.pngAccntSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferPayedFeesId);
            callable.setLong(2, payingAccountVal.getId());
            callable.setLong(3, payingAccountVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long DebitTransferPayedFeesId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".dtrpaydfsFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferPayedFeesId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long DebitTransferPayedFeesId, PersistentDebitTransferPayedFees ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".dtrpaydfsFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, DebitTransferPayedFeesId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

