package persistence;

import model.*;

import java.util.Iterator;

public class Subj_ObserveeProxi extends PersistentListProxi<ObsInterface> {

  	private ObsInterfaceList list;
  	private Subj owner;

  	public Subj_ObserveeProxi(Subj owner) {
    	this.owner = owner;
  	}
  	public ObsInterfaceList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ObsInterfaceList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theSubjFacade.observeeGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<ObsInterface> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(ObsInterface entry) throws PersistenceException {
    	if (entry != null) {
      		ObsInterfaceList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theSubjFacade
        	               	.observeeAdd(owner.getId(), entry);
      		}
      		list.add((ObsInterface)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theSubjFacade.observeeRem(entry.getListEntryId());
    	}
    	
  	}
  	public Subj_ObserveeProxi copy(Subj owner) throws PersistenceException {
  		Subj_ObserveeProxi result = new Subj_ObserveeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<ObsInterface> entries = (this.list == null ? new java.util.Vector<ObsInterface>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			ObsInterface current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theSubjFacade
            	           .observeeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
