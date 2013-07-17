package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class TrancactionFacade{

	private String schemaName;
	private Connection con;

	public TrancactionFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public TrancactionProxi getTheTrancaction() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrncctnFacade.getTheTrncctn; end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (TrancactionProxi)PersistentProxi.createProxi(id, 152);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Trancaction getTrancaction(long TrancactionId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrncctnFacade.getTrncctn(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, TrancactionId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMoney money = null;
            if (obj.getLong(4) != 0)
                money = (PersistentMoney)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentDebitNoteTransaction This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentDebitNoteTransaction)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            Trancaction result = new Trancaction(obj.getLong(2),
                                                 obj.getLong(3),
                                                 money,
                                                 subService,
                                                 This,
                                                 TrancactionId);
            obj.close();
            callable.close();
            TrancactionICProxi inCache = (TrancactionICProxi)Cache.getTheCache().put(result);
            Trancaction objectInCache = (Trancaction)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

