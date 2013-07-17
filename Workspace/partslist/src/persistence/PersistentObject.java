package persistence;

import java.util.HashMap;

public abstract class PersistentObject extends PersistentRoot {

	private boolean delayed$Persistence;

	public boolean isDelayed$Persistence() {
		return delayed$Persistence;
	}
	public void store() throws PersistenceException{
		this.setDelayed$Persistence(false);
	}

	public void setDelayed$Persistence(boolean delayed$Persistence) {
		this.delayed$Persistence = delayed$Persistence;
	}

	public PersistentObject(long id) {
		super(id);
	}

	public PersistentRoot getTheObject() throws PersistenceException {
		return this;
	}

	public java.util.HashMap<String, Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		java.util.HashMap<String, Object> result = new java.util.HashMap<String, Object>();
		this.toHashtable(result, depth, essentialLevel, forGUI, true, tdObserver);
		return result;
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put(common.RPCConstantsAndServices.RPCClassIdFieldName, new Long(this.getClassId()).toString());
		result.put(common.RPCConstantsAndServices.RPCObjectIdFieldName, new Long(this.getId()).toString());
		result.put(common.RPCConstantsAndServices.RPCToStringFieldName, this.toString());
		return result;
	}
	public PersistentObject provideCopy() throws PersistenceException{
		return this;
	}
	private static final model.ToString$Visitor TheToStringVisitor = new model.ToString$Visitor();
	private static final model.GetIconInfo$Visitor TheGetIconInfoVisitor = new model.GetIconInfo$Visitor();

	public String toString(boolean inner)throws PersistenceException{
		if (inner) {
			return new model.ToString$Visitor().toString(getThis());
		}else{
			return this.toString();
		}
	}
	public String toString(){
		try {
			return TheToStringVisitor.toString(getThis());
		} catch (PersistenceException e) {
			return e.getMessage();
		}
	}
	public int getIconInfo() throws PersistenceException {
		return TheGetIconInfoVisitor.getIconInfo(getThis());
	}
	
	public Anything getThis() throws PersistenceException {
		return (Anything) this;
	}
    	
}