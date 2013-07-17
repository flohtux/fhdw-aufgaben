package persistence;

import model.*;

import java.util.Iterator;

public class Product_PartsProxi extends PersistentListProxi<PersistentQPart> {

  	private QPartList list;
  	private Product owner;

  	public Product_PartsProxi(Product owner) {
    	this.owner = owner;
  	}
  	public QPartList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new QPartList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theProductFacade.partsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentQPart> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentQPart entry) throws PersistenceException , model.CycleException{
    	if (entry != null) {
      		if (entry.containsComponentHierarchy(this.owner)) throw new model.CycleException("Cycle in ComponentHierarchy detected!");
      QPartList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theProductFacade
        	               	.partsAdd(owner.getId(), entry);
      		}
      		list.add((PersistentQPart)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theProductFacade.partsRem(entry.getListEntryId());
    	}
    	
  	}
  	public Product_PartsProxi copy(Product owner) throws PersistenceException {
  		Product_PartsProxi result = new Product_PartsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentQPart> entries = (this.list == null ? new java.util.Vector<PersistentQPart>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentQPart current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theProductFacade
            	           .partsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
