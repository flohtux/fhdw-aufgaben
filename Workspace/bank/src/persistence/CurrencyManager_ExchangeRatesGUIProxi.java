package persistence;

import model.*;

import java.util.Iterator;

public class CurrencyManager_ExchangeRatesGUIProxi extends PersistentListProxi<PersistentExchangeRateWrapper> {

  	private ExchangeRateWrapperList list;
  	private CurrencyManager owner;

  	public CurrencyManager_ExchangeRatesGUIProxi(CurrencyManager owner) {
    	this.owner = owner;
  	}
  	public ExchangeRateWrapperList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new ExchangeRateWrapperList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theCurrencyManagerFacade.exchangeRatesGUIGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentExchangeRateWrapper> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentExchangeRateWrapper entry) throws PersistenceException {
    	if (entry != null) {
      		ExchangeRateWrapperList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade
        	               	.exchangeRatesGUIAdd(owner.getId(), entry);
      		}
      		list.add((PersistentExchangeRateWrapper)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade.exchangeRatesGUIRem(entry.getListEntryId());
    	}
    	
  	}
  	public CurrencyManager_ExchangeRatesGUIProxi copy(CurrencyManager owner) throws PersistenceException {
  		CurrencyManager_ExchangeRatesGUIProxi result = new CurrencyManager_ExchangeRatesGUIProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentExchangeRateWrapper> entries = (this.list == null ? new java.util.Vector<PersistentExchangeRateWrapper>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentExchangeRateWrapper current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade
            	           .exchangeRatesGUIAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}
