package persistence;

import model.*;

import java.util.Iterator;

public class Trigger_RulesProxi extends PersistentListProxi<PersistentRule> {

  	private RuleList list;
  	private Trigger owner;

  	public Trigger_RulesProxi(Trigger owner) {
    	this.owner = owner;
  	}
  	public RuleList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new RuleList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theTriggerFacade.rulesGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentRule> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentRule entry) throws PersistenceException {
    	if (entry != null) {
      		RuleList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theTriggerFacade
        	               	.rulesAdd(owner.getId(), entry);
      		}
      		list.add((PersistentRule)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theTriggerFacade.rulesRem(entry.getListEntryId());
    	}
    	
  	}
  	public Trigger_RulesProxi copy(Trigger owner) throws PersistenceException {
  		Trigger_RulesProxi result = new Trigger_RulesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentRule> entries = (this.list == null ? new java.util.Vector<PersistentRule>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentRule current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theTriggerFacade
            	           .rulesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
