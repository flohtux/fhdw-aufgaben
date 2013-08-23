package persistence;

import model.*;

import java.util.Iterator;

public class Account_DebitTransferTransactionsProxi extends PersistentListProxi<PersistentDebitTransferTransaction> {

  	private DebitTransferTransactionList list;
  	private Account owner;

  	public Account_DebitTransferTransactionsProxi(Account owner) {
    	this.owner = owner;
  	}
  	public DebitTransferTransactionList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new DebitTransferTransactionList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theAccountFacade.debitTransferTransactionsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentDebitTransferTransaction> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentDebitTransferTransaction entry) throws PersistenceException {
    	if (entry != null) {
      		DebitTransferTransactionList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
        	               	.debitTransferTransactionsAdd(owner.getId(), entry);
      		}
      		list.add((PersistentDebitTransferTransaction)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theAccountFacade.debitTransferTransactionsRem(entry.getListEntryId());
    	}
    	
  	}
  	public Account_DebitTransferTransactionsProxi copy(Account owner) throws PersistenceException {
  		Account_DebitTransferTransactionsProxi result = new Account_DebitTransferTransactionsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentDebitTransferTransaction> entries = (this.list == null ? new java.util.Vector<PersistentDebitTransferTransaction>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentDebitTransferTransaction current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theAccountFacade
            	           .debitTransferTransactionsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
