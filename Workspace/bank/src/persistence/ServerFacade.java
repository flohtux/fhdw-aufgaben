package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class ServerFacade{

	private String schemaName;
	private Connection con;

	public ServerFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ServerProxi newServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.newSrvr(?,?,?,?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, password);
            callable.setString(3, user);
            callable.setLong(4, hackCount);
            callable.setTimestamp(5, hackDelay);
            callable.setLong(6, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Server result = new Server(null,null,null,password,user,hackCount,hackDelay,id);
            Cache.getTheCache().put(result);
            return (ServerProxi)PersistentProxi.createProxi(id, -121);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ServerProxi newDelayedServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.newDelayedSrvr(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Server result = new Server(null,null,null,password,user,hackCount,hackDelay,id);
            Cache.getTheCache().put(result);
            return (ServerProxi)PersistentProxi.createProxi(id, -121);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Server getServer(long ServerId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.getSrvr(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ServerId);
            callable.execute();
            ResultSet links = ((OracleCallableStatement)callable).getCursor(1);
            PersistentService service = null;
            SubjInterface subService = null;
            PersistentServer This = null;
            String password = "";
            String user = "";
            long hackCount = 0;
            java.sql.Timestamp hackDelay = new java.sql.Timestamp(System.currentTimeMillis());
            while(links.next()){
                long associationId = links.getLong(2);
                switch ((int)associationId) {
                    case 10038: {
                        service = (PersistentService)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10039: {
                        subService = (SubjInterface)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10040: {
                        This = (PersistentServer)PersistentProxi.createProxi(links.getLong(3), links.getLong(4));
                        break;
                    }
                    case 10042: {
                        password = links.getString(6);
                        if(password == null)password = "";
                        break;
                    }
                    case 10043: {
                        user = links.getString(6);
                        if(user == null)user = "";
                        break;
                    }
                    case 10044: {
                        hackCount = links.getLong(5);
                        break;
                    }
                    case 10045: {
                        hackDelay = links.getTimestamp(9);
                        break;
                    }
                }
            }
            Server result = new Server(service, 
                                       subService, 
                                       This, 
                                       password, 
                                       user, 
                                       hackCount, 
                                       hackDelay, 
                                       ServerId);
            links.close();
            callable.close();
            ServerICProxi inCache = (ServerICProxi)Cache.getTheCache().put(result);
            Server objectInCache = (Server)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.getClass(?); end;");
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
    public ServerSearchList getServerByUser(String user) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.getSrvrByUser(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setString(2, user);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ServerSearchList result = new ServerSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                ServerProxi proxi = (ServerProxi)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void serviceSet(long ServerId, PersistentService serviceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.srvcSet(?, ?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setLong(2, serviceVal.getId());
            callable.setLong(3, serviceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long ServerId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ServerId, PersistentServer ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void passwordSet(long ServerId, String passwordVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.passwordSet(?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setString(2, passwordVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void userSet(long ServerId, String userVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.userSet(?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setString(2, userVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void hackCountSet(long ServerId, long hackCountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.hackCountSet(?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setLong(2, hackCountVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void hackDelaySet(long ServerId, java.sql.Timestamp hackDelayVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvrFacade.hackDelaySet(?, ?); end;");
            callable.setLong(1, ServerId);
            callable.setTimestamp(2, hackDelayVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ServerSearchList inverseGetService(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvrFacade.iGetSrvc(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ServerSearchList result = new ServerSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentServer)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentServer)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

