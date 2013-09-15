package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class AmountFacade{

	private String schemaName;
	private Connection con;

	public AmountFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public AmountProxi newAmount(common.Fraction balance,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AmntFacade.newAmnt(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, balance.toString());
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Amount result = new Amount(balance,null,null,id);
            Cache.getTheCache().put(result);
            return (AmountProxi)PersistentProxi.createProxi(id, 115);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AmountProxi newDelayedAmount(common.Fraction balance) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".AmntFacade.newDelayedAmnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Amount result = new Amount(balance,null,null,id);
            Cache.getTheCache().put(result);
            return (AmountProxi)PersistentProxi.createProxi(id, 115);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Amount getAmount(long AmountId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AmntFacade.getAmnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, AmountId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            common.Fraction balance = common.Fraction.Null;
            SubjInterface subService = null;
            PersistentAmount This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10027: {
                        balance = common.Fraction.parse(links.getString(10));
                        break;
                    }
                    case 10028: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10029: {
                        This = (PersistentAmount)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            Amount result = new Amount(balance, 
                                       subService, 
                                       This, 
                                       AmountId);
            links.close();
            callable.close();
            AmountICProxi inCache = (AmountICProxi)Cache.getTheCache().put(result);
            Amount objectInCache = (Amount)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AmntFacade.getClass(?); end;");
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
    public void balanceSet(long AmountId, common.Fraction balanceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AmntFacade.blncSet(?, ?); end;");
            callable.setLong(1, AmountId);
            callable.setString(2, balanceVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long AmountId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AmntFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, AmountId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long AmountId, PersistentAmount ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".AmntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, AmountId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

