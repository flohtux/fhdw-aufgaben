package persistence;

import model.*;
import java.util.Hashtable;

public class CurrencyManager_ExchangeProxi {

	private CurrencyManager owner;

	private Hashtable<PersistentCurrency, PersistentAmount> data;
	private AmountSearchList values;

	public CurrencyManager_ExchangeProxi(CurrencyManager owner) {
		this.owner = owner;
		this.data = new Hashtable<PersistentCurrency, PersistentAmount>();
	}

	public synchronized void put(PersistentCurrency key, PersistentAmount entry) throws PersistenceException {
		if (key == null) throw new PersistenceException("Null not allowed for map keys!",0);
		if (entry == null) throw new PersistenceException("Null not allowed for map values!",0);
		
		if (!this.owner.isDelayed$Persistence()){
			key.store();
			entry.store();
			ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade.exchangeAdd(owner.getId(), key, entry);
		}
		this.data.put(key, entry);
		this.values = null;
		
	}

	public synchronized PersistentAmount get(PersistentCurrency key) throws PersistenceException {
		PersistentAmount result = this.data.get(key);
		if (result == null && !this.owner.isDelayed$Persistence()) {
			result = ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade.exchangeGet(owner.getId(), key);
			if (result != null)
				this.data.put(key, result);
		}
		return result;
	}

	public synchronized void remove(PersistentCurrency key) throws PersistenceException {
		
		this.data.remove(key);
		this.values = null;
		if (!this.owner.isDelayed$Persistence()){
			ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade.exchangeRem(this.owner.getId(), key);
		}
	}
	
	@SuppressWarnings("unchecked")
	public CurrencyManager_ExchangeProxi copy(CurrencyManager owner) throws PersistenceException {
		CurrencyManager_ExchangeProxi result = new CurrencyManager_ExchangeProxi(owner);
		result.data = (Hashtable<PersistentCurrency, PersistentAmount>) this.data.clone();
		return result;
	}
	
	public AmountSearchList getValues() throws PersistenceException {
		if (this.values == null) {
			if (this.owner.isDelayed$Persistence()){
				this.values = new AmountSearchList();
				for (PersistentAmount current : this.data.values()) {
					this.values.add(current);
				}
			} else {
				this.values = ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade.exchangeGetValues(owner.getId());
			}		
		}
		return this.values;
	}
	public void store() throws PersistenceException {
		java.util.Iterator<PersistentCurrency> keys = this.data.keySet().iterator();
		while (keys.hasNext()){
			PersistentCurrency key = keys.next();
			key.store();
			data.get(key).store();
			ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade.exchangeAdd(owner.getId(), key, data.get(key));
		}
	}
}
