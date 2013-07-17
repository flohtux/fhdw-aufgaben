package persistence;

import model.*;

import java.util.Iterator;

public class Server_ComponentsProxi extends PersistentListProxi<PersistentComponent> {

  	private ComponentList list;
  	private Server owner;

  	public Server_ComponentsProxi(Server owner) {
    	this.owner = owner;
  	}
  	public ComponentList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ComponentList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theServerFacade.componentsGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentComponent> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentComponent entry) throws PersistenceException {
    	if (entry != null) {
      		ComponentList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theServerFacade
        	               	.componentsAdd(owner.getId(), entry);
      		}
      		list.add((PersistentComponent)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theServerFacade.componentsRem(entry.getListEntryId());
    	}
    	
  	}
  	public Server_ComponentsProxi copy(Server owner) throws PersistenceException {
  		Server_ComponentsProxi result = new Server_ComponentsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentComponent> entries = (this.list == null ? new java.util.Vector<PersistentComponent>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentComponent current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theServerFacade
            	           .componentsAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
