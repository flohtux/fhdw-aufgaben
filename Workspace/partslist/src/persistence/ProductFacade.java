package persistence;

import model.*;

import java.sql.*;
import oracle.jdbc.*;

public class ProductFacade{

	private String schemaName;
	private Connection con;

	public ProductFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public ProductProxi newProduct(String name,long createMinusStorePlus) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.newPrdct(?,?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setString(2, name);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Product result = new Product(name,null,null,id);
            Cache.getTheCache().put(result);
            return (ProductProxi)PersistentProxi.createProxi(id, 104);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ProductProxi newDelayedProduct(String name) throws PersistenceException {
        OracleCallableStatement callable;
        try{
            callable = (OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.newDelayedPrdct(); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Product result = new Product(name,null,null,id);
            Cache.getTheCache().put(result);
            return (ProductProxi)PersistentProxi.createProxi(id, 104);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Product getProduct(long ProductId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.getPrdct(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ProductId);
            callable.execute();
            ResultSet obj = ((OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentState currentState = null;
            if (obj.getLong(3) != 0)
                currentState = (PersistentState)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentComponent This = null;
            if (obj.getLong(5) != 0)
                This = (PersistentComponent)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            Product result = new Product(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                         currentState,
                                         This,
                                         ProductId);
            obj.close();
            callable.close();
            ProductICProxi inCache = (ProductICProxi)Cache.getTheCache().put(result);
            Product objectInCache = (Product)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long partsAdd(long ProductId, PersistentQPart partsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.prtsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.NUMBER);
            callable.setLong(2, ProductId);
            callable.setLong(3, partsVal.getId());
            callable.setLong(4, partsVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void partsRem(long partsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".PrdctFacade.prtsRem(?); end;");
            callable.setLong(1, partsId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public QPartList partsGet(long ProductId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.prtsGet(?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, ProductId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            QPartList result = new QPartList();
            while (list.next()) {
                result.add((PersistentQPart)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public ProductSearchList inverseGetParts(long objectId, long classId)throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".PrdctFacade.iGetPrts(?, ?); end;");
            callable.registerOutParameter(1, OracleTypes.CURSOR);
            callable.setLong(2, objectId);
            callable.setLong(3, classId);
            callable.execute();
            ResultSet list = ((OracleCallableStatement)callable).getCursor(1);
            ProductSearchList result = new ProductSearchList();
            while (list.next()) {
                if (list.getLong(3) != 0) result.add((PersistentProduct)PersistentProxi.createProxi(list.getLong(3), list.getLong(4)));
                else result.add((PersistentProduct)PersistentProxi.createProxi(list.getLong(1), list.getLong(2)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

