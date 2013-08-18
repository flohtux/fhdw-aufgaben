package persistence;

import model.*;

import java.util.Iterator;

public class CurrencyManager_CurrencyStockProxi extends PersistentListProxi<PersistentMoney> {

  	private MoneyList list;
  	private CurrencyManager owner;

  	public CurrencyManager_CurrencyStockProxi(CurrencyManager owner) {
    	this.owner = owner;
  	}
  	public MoneyList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new MoneyList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theCurrencyManagerFacade.currencyStockGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentMoney> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentMoney entry) throws PersistenceException {
    	if (entry != null) {
      		MoneyList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade
        	               	.currencyStockAdd(owner.getId(), entry);
      		}
      		list.add((PersistentMoney)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade.currencyStockRem(entry.getListEntryId());
    	}
    	
  	}
  	public CurrencyManager_CurrencyStockProxi copy(CurrencyManager owner) throws PersistenceException {
  		CurrencyManager_CurrencyStockProxi result = new CurrencyManager_CurrencyStockProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentMoney> entries = (this.list == null ? new java.util.Vector<PersistentMoney>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentMoney current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade
            	           .currencyStockAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
