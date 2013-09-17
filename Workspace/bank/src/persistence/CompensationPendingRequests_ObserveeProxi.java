package persistence;

import model.*;

import java.util.Iterator;

public class CompensationPendingRequests_ObserveeProxi extends PersistentListProxi<PersistentCompensationRequest> {

  	private CompensationRequestList list;
  	private CompensationPendingRequests owner;

  	public CompensationPendingRequests_ObserveeProxi(CompensationPendingRequests owner) {
    	this.owner = owner;
  	}
  	public CompensationRequestList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new CompensationRequestList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theCompensationPendingRequestsFacade.observeeGet(this.owner.getId());
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
        		entryId = ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade
        	               	.observeeAdd(owner.getId(), entry);
      		}
      		list.add((PersistentCompensationRequest)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		entry.register(this.owner);
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade.observeeRem(entry.getListEntryId());
    	}
    	((PersistentCompensationRequest)entry).deregister(this.owner);
  	}
  	public CompensationPendingRequests_ObserveeProxi copy(CompensationPendingRequests owner) throws PersistenceException {
  		CompensationPendingRequests_ObserveeProxi result = new CompensationPendingRequests_ObserveeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentCompensationRequest> entries = (this.list == null ? new java.util.Vector<PersistentCompensationRequest>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentCompensationRequest current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade
            	           .observeeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
