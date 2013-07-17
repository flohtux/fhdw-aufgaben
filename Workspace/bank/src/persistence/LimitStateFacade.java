package persistence;



import java.sql.*;
import oracle.jdbc.*;

public class LimitStateFacade{

	private String schemaName;
	private Connection con;

	public LimitStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public void balanceSet(long LimitStateId, PersistentAmount balanceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".LmtSttFacade.blncSet(?, ?, ?); end;");
            callable.setLong(1, LimitStateId);
            callable.setLong(2, balanceVal.getId());
            callable.setLong(3, balanceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

