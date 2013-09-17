package persistence;

import model.*;

import java.util.Iterator;

public class Compensation_TransactionsToBeCompensatedProxi extends PersistentListProxi<PersistentDebitTransferTransaction> {

  	private DebitTransferTransactionList list;
  	private Compensation owner;

  	public Compensation_TransactionsToBeCompensatedProxi(Compensation owner) {
    	this.owner = owner;
  	}
  	public DebitTransferTransactionList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new DebitTransferTransactionList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theCompensationFacade.transactionsToBeCompensatedGet(this.owner.getId());
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
        		entryId = ConnectionHandler.getTheConnectionHandler().theCompensationFacade
        	               	.transactionsToBeCompensatedAdd(owner.getId(), entry);
      		}
      		list.add((PersistentDebitTransferTransaction)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theCompensationFacade.transactionsToBeCompensatedRem(entry.getListEntryId());
    	}
    	
  	}
  	public Compensation_TransactionsToBeCompensatedProxi copy(Compensation owner) throws PersistenceException {
  		Compensation_TransactionsToBeCompensatedProxi result = new Compensation_TransactionsToBeCompensatedProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentDebitTransferTransaction> entries = (this.list == null ? new java.util.Vector<PersistentDebitTransferTransaction>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentDebitTransferTransaction current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theCompensationFacade
            	           .transactionsToBeCompensatedAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
