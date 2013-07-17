package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class ServiceFacade{

	private String schemaName;
	private Connection con;

	public ServiceFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SrvcFacade.getClass(?); end;");
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
    public void subServiceSet(long ServiceId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvcFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, ServiceId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ServiceId, PersistentService ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".SrvcFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ServiceId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

