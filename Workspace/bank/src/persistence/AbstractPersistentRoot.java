package persistence;

import java.util.HashMap;

public interface AbstractPersistentRoot {

  public long getId();
  public long getClassId();
  public PersistentRoot getTheObject()  throws PersistenceException;
  
  public void setDelayed$Persistence(boolean b) throws PersistenceException; 
  public boolean isDelayed$Persistence() throws PersistenceException; 
  public void store() throws PersistenceException;
  
  public HashMap<String, Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver)throws PersistenceException;
  public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver)throws PersistenceException;
 
  abstract boolean hasEssentialFields() throws PersistenceException;
  abstract public String toString(boolean inner) throws PersistenceException;
  abstract public void delete$Me() throws PersistenceException ;
  abstract public String createProxiInformation(boolean asLeaf, boolean withLeafInfo) throws PersistenceException; 
  
  abstract public int getIconInfo() throws PersistenceException;
  abstract public int getLeafInfo() throws PersistenceException;
  
  
}
