package persistence;

import model.*;

import java.util.Iterator;

public class CompensationListe_CompensationsProxi extends PersistentListProxi<PersistentCompensation> {

  	private CompensationList list;
  	private CompensationListe owner;

  	public CompensationListe_CompensationsProxi(CompensationListe owner) {
    	this.owner = owner;
  	}
  	public CompensationList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new CompensationList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theCompensationListeFacade.compensationsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentCompensation> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentCompensation entry) throws PersistenceException {
    	if (entry != null) {
      		CompensationList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade
        	               	.compensationsAdd(owner.getId(), entry);
      		}
      		list.add((PersistentCompensation)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade.compensationsRem(entry.getListEntryId());
    	}
    	
  	}
  	public CompensationListe_CompensationsProxi copy(CompensationListe owner) throws PersistenceException {
  		CompensationListe_CompensationsProxi result = new CompensationListe_CompensationsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentCompensation> entries = (this.list == null ? new java.util.Vector<PersistentCompensation>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentCompensation current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theCompensationListeFacade
            	           .compensationsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
