package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class QPartFacade{

	private String schemaName;
	private Connection con;

	public QPartFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public QPartProxi newQPart(long amount,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".QPrtFacade.newQPrt(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, amount);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            QPart result = new QPart(amount,null,null,id);
            Cache.getTheCache().put(result);
            return (QPartProxi)PersistentProxi.createProxi(id, 105);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public QPartProxi newDelayedQPart(long amount) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".QPrtFacade.newDelayedQPrt(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            QPart result = new QPart(amount,null,null,id);
            Cache.getTheCache().put(result);
            return (QPartProxi)PersistentProxi.createProxi(id, 105);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public QPart getQPart(long QPartId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".QPrtFacade.getQPrt(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, QPartId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentComponent component = null;
            if (obj.getLong(3) != 0)
                component = (PersistentComponent)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentQPart This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentQPart)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            QPart result = new QPart(obj.getLong(2),
                                     component,
                                     This,
                                     QPartId);
            obj.close();
            callable.close();
            QPartICProxi inCache = (QPartICProxi)Cache.getTheCache().put(result);
            QPart objectInCache = (QPart)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".QPrtFacade.getClass(?); end;");
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
    public void amountSet(long QPartId, long amountVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".QPrtFacade.amntSet(?, ?); end;");
            callable.setLong(1, QPartId);
            callable.setLong(2, amountVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void componentSet(long QPartId, PersistentComponent componentVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".QPrtFacade.cmpnntSet(?, ?, ?); end;");
            callable.setLong(1, QPartId);
            callable.setLong(2, componentVal.getId());
            callable.setLong(3, componentVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long QPartId, PersistentQPart ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".QPrtFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, QPartId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public QPartSearchList inverseGetComponent(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".QPrtFacade.iGetCmpnnt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            QPartSearchList result = new QPartSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentQPart)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentQPart)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

