package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class PercentFacade{

	private String schemaName;
	private Connection con;

	public PercentFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PercentProxi newPercent(common.Fraction value,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrcntFacade.newPrcnt(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, value.toString());
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Percent result = new Percent(value,null,null,id);
            Cache.getTheCache().put(result);
            return (PercentProxi)PersistentProxi.createProxi(id, 112);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PercentProxi newDelayedPercent(common.Fraction value) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrcntFacade.newDelayedPrcnt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Percent result = new Percent(value,null,null,id);
            Cache.getTheCache().put(result);
            return (PercentProxi)PersistentProxi.createProxi(id, 112);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Percent getPercent(long PercentId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrcntFacade.getPrcnt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, PercentId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            common.Fraction value = common.Fraction.Null;
            SubjInterface subService = null;
            PersistentPercent This = null;
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10022: {
                        value = common.Fraction.parse(links.getString(10));
                        break;
                    }
                    case 10023: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10024: {
                        This = (PersistentPercent)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                }
            }
            Percent result = new Percent(value, 
                                         subService, 
                                         This, 
                                         PercentId);
            links.close();
            callable.close();
            PercentICProxi inCache = (PercentICProxi)Cache.getTheCache().put(result);
            Percent objectInCache = (Percent)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrcntFacade.getClass(?); end;");
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
    public void valueSet(long PercentId, common.Fraction valueVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrcntFacade.vlSet(?, ?); end;");
            callable.setLong(1, PercentId);
            callable.setString(2, valueVal.toString());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long PercentId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrcntFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, PercentId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long PercentId, PersistentPercent ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrcntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, PercentId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

