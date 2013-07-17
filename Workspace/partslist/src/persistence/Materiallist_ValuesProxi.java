package persistence;

import model.*;

import java.util.Iterator;

public class Materiallist_ValuesProxi extends PersistentListProxi<PersistentMateriallistValue> {

  	private MateriallistValueList list;
  	private Materiallist owner;

  	public Materiallist_ValuesProxi(Materiallist owner) {
    	this.owner = owner;
  	}
  	public MateriallistValueList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new MateriallistValueList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theMateriallistFacade.valuesGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentMateriallistValue> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentMateriallistValue entry) throws PersistenceException {
    	if (entry != null) {
      		MateriallistValueList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theMateriallistFacade
        	               	.valuesAdd(owner.getId(), entry);
      		}
      		list.add((PersistentMateriallistValue)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theMateriallistFacade.valuesRem(entry.getListEntryId());
    	}
    	
  	}
  	public Materiallist_ValuesProxi copy(Materiallist owner) throws PersistenceException {
  		Materiallist_ValuesProxi result = new Materiallist_ValuesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentMateriallistValue> entries = (this.list == null ? new java.util.Vector<PersistentMateriallistValue>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentMateriallistValue current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theMateriallistFacade
            	           .valuesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
