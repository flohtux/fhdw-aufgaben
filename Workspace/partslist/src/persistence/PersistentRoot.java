package persistence;

import java.util.HashMap;;

public abstract class PersistentRoot implements AbstractPersistentRoot {

  private long id; 

  public PersistentRoot(long id) {
    this.id = id;
  }

  public long getId(){
    return this.id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public boolean equals(Object object){
    PersistentRoot argument;
    if(object == null) return false;
    try {
      argument = (PersistentRoot)object;
    }catch (ClassCastException cce) {
      return false;
    }
    return this.id == argument.id && this.getClassId() == argument.getClassId();
  }
  public int hashCode(){
	return new Long(id).intValue();
  }
  
  abstract public void setDelayed$Persistence(boolean b) throws PersistenceException;
  abstract public boolean isDelayed$Persistence() throws PersistenceException;

  public abstract long getClassId();
  public abstract PersistentRoot getTheObject()  throws PersistenceException;
  public abstract HashMap<String, Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException;
  public abstract HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException;

  public abstract boolean hasEssentialFields() throws PersistenceException;

  public abstract String toString(boolean inner)throws PersistenceException;

  public void delete$Me() throws PersistenceException{
	  if (!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().dltObjct(this);
  }

  public String createProxiInformation(boolean asLeaf, boolean withLeafInfo) throws PersistenceException {
	  return common.RPCConstantsAndServices.createProxiRepresentation(this.getClassId(), this.getId(), 
			  														  this.getIconInfo(), (asLeaf ? 0 : (withLeafInfo ? this.getLeafInfo() : 1)), this.toString());
  }

  public int getLeafInfo() throws PersistenceException {
	  return 1;
  }

  abstract public int getIconInfo() throws PersistenceException;
}
