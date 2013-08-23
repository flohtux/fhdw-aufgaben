package persistence;

import model.*;

import java.util.Iterator;

public class DebitTransferTemplate_TemplatesProxi extends PersistentListProxi<PersistentDebitTransfer> {

  	private DebitTransferList list;
  	private DebitTransferTemplate owner;

  	public DebitTransferTemplate_TemplatesProxi(DebitTransferTemplate owner) {
    	this.owner = owner;
  	}
  	public DebitTransferList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new DebitTransferList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theDebitTransferTemplateFacade.templatesGet(this.owner.getId());
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
        		entryId = ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade
        	               	.templatesAdd(owner.getId(), entry);
      		}
      		list.add((PersistentDebitTransfer)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade.templatesRem(entry.getListEntryId());
    	}
    	
  	}
  	public DebitTransferTemplate_TemplatesProxi copy(DebitTransferTemplate owner) throws PersistenceException {
  		DebitTransferTemplate_TemplatesProxi result = new DebitTransferTemplate_TemplatesProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentDebitTransfer> entries = (this.list == null ? new java.util.Vector<PersistentDebitTransfer>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentDebitTransfer current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade
            	           .templatesAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
