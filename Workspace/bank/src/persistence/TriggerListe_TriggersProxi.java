package persistence;

import model.*;

import java.util.Iterator;

public class TriggerListe_TriggersProxi extends PersistentListProxi<PersistentTrigger> {

  	private TriggerList list;
  	private TriggerListe owner;

  	public TriggerListe_TriggersProxi(TriggerListe owner) {
    	this.owner = owner;
  	}
  	public TriggerList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new TriggerList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theTriggerListeFacade.triggersGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentTrigger> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentTrigger entry) throws PersistenceException {
    	if (entry != null) {
      		TriggerList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade
        	               	.triggersAdd(owner.getId(), entry);
      		}
      		list.add((PersistentTrigger)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade.triggersRem(entry.getListEntryId());
    	}
    	
  	}
  	public TriggerListe_TriggersProxi copy(TriggerListe owner) throws PersistenceException {
  		TriggerListe_TriggersProxi result = new TriggerListe_TriggersProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentTrigger> entries = (this.list == null ? new java.util.Vector<PersistentTrigger>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentTrigger current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade
            	           .triggersAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
