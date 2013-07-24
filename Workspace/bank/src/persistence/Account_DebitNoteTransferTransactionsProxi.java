package persistence;

import model.*;

import java.util.Iterator;

public class Account_DebitNoteTransferTransactionsProxi extends PersistentListProxi<PersistentDebitNoteTransferTransaction> {

  	private DebitNoteTransferTransactionList list;
  	private Account owner;

  	public Account_DebitNoteTransferTransactionsProxi(Account owner) {
    	this.owner = owner;
  	}
  	public DebitNoteTransferTransactionList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new DebitNoteTransferTransactionList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAccountFacade.debitNoteTransferTransactionsGet(this.owner.getId());
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
        		entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
        	               	.debitNoteTransferTransactionsAdd(owner.getId(), entry);
      		}
      		list.add((PersistentDebitNoteTransferTransaction)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAccountFacade.debitNoteTransferTransactionsRem(entry.getListEntryId());
    	}
    	
  	}
  	public Account_DebitNoteTransferTransactionsProxi copy(Account owner) throws PersistenceException {
  		Account_DebitNoteTransferTransactionsProxi result = new Account_DebitNoteTransferTransactionsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentDebitNoteTransferTransaction> entries = (this.list == null ? new java.util.Vector<PersistentDebitNoteTransferTransaction>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentDebitNoteTransferTransaction current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
            	           .debitNoteTransferTransactionsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
