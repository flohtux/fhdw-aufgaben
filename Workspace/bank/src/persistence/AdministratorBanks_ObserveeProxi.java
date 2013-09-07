package persistence;

import model.*;

import java.util.Iterator;

public class AdministratorBanks_ObserveeProxi extends PersistentListProxi<PersistentBankPx> {

  	private BankPxList list;
  	private AdministratorBanks owner;

  	public AdministratorBanks_ObserveeProxi(AdministratorBanks owner) {
    	this.owner = owner;
  	}
  	public BankPxList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new BankPxList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAdministratorBanksFacade.observeeGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentBankPx> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentBankPx entry) throws PersistenceException {
    	if (entry != null) {
      		BankPxList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade
        	               	.observeeAdd(owner.getId(), entry);
      		}
      		list.add((PersistentBankPx)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		entry.register(this.owner);
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade.observeeRem(entry.getListEntryId());
    	}
    	((PersistentBankPx)entry).deregister(this.owner);
  	}
  	public AdministratorBanks_ObserveeProxi copy(AdministratorBanks owner) throws PersistenceException {
  		AdministratorBanks_ObserveeProxi result = new AdministratorBanks_ObserveeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentBankPx> entries = (this.list == null ? new java.util.Vector<PersistentBankPx>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentBankPx current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAdministratorBanksFacade
            	           .observeeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
