package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class PartsListManagerFacade{

	private String schemaName;
	private Connection con;

	public PartsListManagerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PartsListManagerProxi getThePartsListManager() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.getThePrtsLstMngr; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PartsListManagerProxi)PersistentProxi.createProxi(id, 103);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PartsListManager getPartsListManager(long PartsListManagerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.getPrtsLstMngr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, PartsListManagerId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentPartsListManager This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentPartsListManager)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PartsListManager result = new PartsListManager(This,
                                                           PartsListManagerId);
            obj.close();
            callable.close();
            PartsListManagerICProxi inCache = (PartsListManagerICProxi)Cache.getTheCache().put(result);
            PartsListManager objectInCache = (PartsListManager)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrtsLstMngrFacade.getClass(?); end;");
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
    public void ThisSet(long PartsListManagerId, PersistentPartsListManager ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrtsLstMngrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, PartsListManagerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

