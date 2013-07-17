package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class ComponentFacade{

	private String schemaName;
	private Connection con;

	public ComponentFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntFacade.getClass(?); end;");
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
    public ComponentSearchList getComponentByName(String name) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntFacade.getCmpnntByNm(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setString(2, name);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ComponentSearchList result = new ComponentSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                ComponentProxi proxi = (ComponentProxi)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void nameSet(long ComponentId, String nameVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnntFacade.nmSet(?, ?); end;");
            callable.setLong(1, ComponentId);
            callable.setString(2, nameVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void currentStateSet(long ComponentId, PersistentState currentStateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnntFacade.crrntSttSet(?, ?, ?); end;");
            callable.setLong(1, ComponentId);
            callable.setLong(2, currentStateVal.getId());
            callable.setLong(3, currentStateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ComponentId, PersistentComponent ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmpnntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ComponentId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ComponentSearchList inverseGetCurrentState(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmpnntFacade.iGetCrrntStt(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ComponentSearchList result = new ComponentSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentComponent)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentComponent)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

