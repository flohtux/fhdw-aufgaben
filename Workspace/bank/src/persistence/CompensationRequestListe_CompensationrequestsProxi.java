package persistence;

import model.*;

import java.util.Iterator;

public class CompensationRequestListe_CompensationrequestsProxi extends PersistentListProxi<PersistentCompensationRequest> {

  	private CompensationRequestList list;
  	private CompensationRequestListe owner;

  	public CompensationRequestListe_CompensationrequestsProxi(CompensationRequestListe owner) {
    	this.owner = owner;
  	}
  	public CompensationRequestList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new CompensationRequestList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theCompensationRequestListeFacade.compensationrequestsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentCompensationRequest> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentCompensationRequest entry) throws PersistenceException {
    	if (entry != null) {
      		CompensationRequestList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade
        	               	.compensationrequestsAdd(owner.getId(), entry);
      		}
      		list.add((PersistentCompensationRequest)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade.compensationrequestsRem(entry.getListEntryId());
    	}
    	
  	}
  	public CompensationRequestListe_CompensationrequestsProxi copy(CompensationRequestListe owner) throws PersistenceException {
  		CompensationRequestListe_CompensationrequestsProxi result = new CompensationRequestListe_CompensationrequestsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentCompensationRequest> entries = (this.list == null ? new java.util.Vector<PersistentCompensationRequest>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentCompensationRequest current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theCompensationRequestListeFacade
            	           .compensationrequestsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
