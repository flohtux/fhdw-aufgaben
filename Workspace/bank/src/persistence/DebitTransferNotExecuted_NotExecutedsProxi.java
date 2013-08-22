package persistence;

import model.*;

import java.util.Iterator;

public class DebitTransferNotExecuted_NotExecutedsProxi extends PersistentListProxi<PersistentDebitTransfer> {

  	private DebitTransferList list;
  	private DebitTransferNotExecuted owner;

  	public DebitTransferNotExecuted_NotExecutedsProxi(DebitTransferNotExecuted owner) {
    	this.owner = owner;
  	}
  	public DebitTransferList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new DebitTransferList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theDebitTransferNotExecutedFacade.notExecutedsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentDebitTransfer> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentDebitTransfer entry) throws PersistenceException {
    	if (entry != null) {
      		DebitTransferList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theDebitTransferNotExecutedFacade
        	               	.notExecutedsAdd(owner.getId(), entry);
      		}
      		list.add((PersistentDebitTransfer)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theDebitTransferNotExecutedFacade.notExecutedsRem(entry.getListEntryId());
    	}
    	
  	}
  	public DebitTransferNotExecuted_NotExecutedsProxi copy(DebitTransferNotExecuted owner) throws PersistenceException {
  		DebitTransferNotExecuted_NotExecutedsProxi result = new DebitTransferNotExecuted_NotExecutedsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentDebitTransfer> entries = (this.list == null ? new java.util.Vector<PersistentDebitTransfer>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentDebitTransfer current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theDebitTransferNotExecutedFacade
            	           .notExecutedsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
