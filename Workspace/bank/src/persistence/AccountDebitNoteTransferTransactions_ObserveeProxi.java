package persistence;

import model.*;

import java.util.Iterator;

public class AccountDebitNoteTransferTransactions_ObserveeProxi extends PersistentListProxi<PersistentDebitNoteTransferTransaction> {

  	private DebitNoteTransferTransactionList list;
  	private AccountDebitNoteTransferTransactions owner;

  	public AccountDebitNoteTransferTransactions_ObserveeProxi(AccountDebitNoteTransferTransactions owner) {
    	this.owner = owner;
  	}
  	public DebitNoteTransferTransactionList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new DebitNoteTransferTransactionList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAccountDebitNoteTransferTransactionsFacade.observeeGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentDebitNoteTransferTransaction> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentDebitNoteTransferTransaction entry) throws PersistenceException {
    	if (entry != null) {
      		DebitNoteTransferTransactionList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAccountDebitNoteTransferTransactionsFacade
        	               	.observeeAdd(owner.getId(), entry);
      		}
      		list.add((PersistentDebitNoteTransferTransaction)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		entry.register(this.owner);
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAccountDebitNoteTransferTransactionsFacade.observeeRem(entry.getListEntryId());
    	}
    	((PersistentDebitNoteTransferTransaction)entry).deregister(this.owner);
  	}
  	public AccountDebitNoteTransferTransactions_ObserveeProxi copy(AccountDebitNoteTransferTransactions owner) throws PersistenceException {
  		AccountDebitNoteTransferTransactions_ObserveeProxi result = new AccountDebitNoteTransferTransactions_ObserveeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentDebitNoteTransferTransaction> entries = (this.list == null ? new java.util.Vector<PersistentDebitNoteTransferTransaction>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentDebitNoteTransferTransaction current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAccountDebitNoteTransferTransactionsFacade
            	           .observeeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
