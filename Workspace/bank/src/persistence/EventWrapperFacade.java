package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class EventWrapperFacade{

	private String schemaName;
	private Connection con;

	public EventWrapperFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public EventWrapperProxi newEventWrapper(long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".EvntWrpprFacade.newEvntWrppr(?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            EventWrapper result = new EventWrapper(null,null,id);
            Cache.getTheCache().put(result);
            return (EventWrapperProxi)PersistentProxi.createProxi(id, 227);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public EventWrapperProxi newDelayedEventWrapper() throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".EvntWrpprFacade.newDelayedEvntWrppr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            EventWrapper result = new EventWrapper(null,null,id);
            Cache.getTheCache().put(result);
            return (EventWrapperProxi)PersistentProxi.createProxi(id, 227);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public EventWrapper getEventWrapper(long EventWrapperId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".EvntWrpprFacade.getEvntWrppr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, EventWrapperId);
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
            PersistentEventWrapper This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentEventWrapper)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            EventWrapper result = new EventWrapper(subService,
                                                   This,
                                                   EventWrapperId);
            obj.close();
            callable.close();
            EventWrapperICProxi inCache = (EventWrapperICProxi)Cache.getTheCache().put(result);
            EventWrapper objectInCache = (EventWrapper)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".EvntWrpprFacade.getClass(?); end;");
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
    public void subServiceSet(long EventWrapperId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".EvntWrpprFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, EventWrapperId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long EventWrapperId, PersistentEventWrapper ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".EvntWrpprFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, EventWrapperId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

