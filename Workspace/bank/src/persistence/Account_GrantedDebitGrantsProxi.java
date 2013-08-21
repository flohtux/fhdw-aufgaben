package persistence;

import model.*;

import java.util.Iterator;

public class Account_GrantedDebitGrantsProxi extends PersistentListProxi<PersistentDebitGrant> {

  	private DebitGrantList list;
  	private Account owner;

  	public Account_GrantedDebitGrantsProxi(Account owner) {
    	this.owner = owner;
  	}
  	public DebitGrantList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new DebitGrantList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAccountFacade.grantedDebitGrantsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentDebitGrant> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentDebitGrant entry) throws PersistenceException {
    	if (entry != null) {
      		DebitGrantList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
        	               	.grantedDebitGrantsAdd(owner.getId(), entry);
      		}
      		list.add((PersistentDebitGrant)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAccountFacade.grantedDebitGrantsRem(entry.getListEntryId());
    	}
    	
  	}
  	public Account_GrantedDebitGrantsProxi copy(Account owner) throws PersistenceException {
  		Account_GrantedDebitGrantsProxi result = new Account_GrantedDebitGrantsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentDebitGrant> entries = (this.list == null ? new java.util.Vector<PersistentDebitGrant>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentDebitGrant current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
            	           .grantedDebitGrantsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
