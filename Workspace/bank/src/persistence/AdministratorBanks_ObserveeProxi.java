package persistence;

import model.*;

import java.util.Iterator;

public class AdministratorBanks_ObserveeProxi extends PersistentListProxi<PersistentBank> {

  	private BankList list;
  	private AdministratorBanks owner;

  	public AdministratorBanks_ObserveeProxi(AdministratorBanks owner) {
    	this.owner = owner;
  	}
  	public BankList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new BankList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAdministratorBanksFacade.observeeGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentBank> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentBank entry) throws PersistenceException {
    	if (entry != null) {
      		BankList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade
        	               	.observeeAdd(owner.getId(), entry);
      		}
      		list.add((PersistentBank)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		entry.register(this.owner);
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade.observeeRem(entry.getListEntryId());
    	}
    	((PersistentBank)entry).deregister(this.owner);
  	}
  	public AdministratorBanks_ObserveeProxi copy(AdministratorBanks owner) throws PersistenceException {
  		AdministratorBanks_ObserveeProxi result = new AdministratorBanks_ObserveeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentBank> entries = (this.list == null ? new java.util.Vector<PersistentBank>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentBank current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade
            	           .observeeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
