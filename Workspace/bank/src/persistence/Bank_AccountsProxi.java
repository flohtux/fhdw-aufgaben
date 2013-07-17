package persistence;

import model.*;
import java.util.Hashtable;

public class Bank_AccountsProxi {

	private Bank owner;

	private Hashtable<Long, PersistentAccount> data;
	private AccountSearchList values;

	public Bank_AccountsProxi(Bank owner) {
		this.owner = owner;
		this.data = new Hashtable<Long, PersistentAccount>();
	}

	public synchronized void put(long key, PersistentAccount entry) throws PersistenceException {
		
		if (entry == null) throw new PersistenceException("Null not allowed for map values!",0);
		
		if (!this.owner.isDelayed$Persistence()){
			entry.store();
			ConnectionHandler.getTheConnectionHandler().theBankFacade.accountsAdd(owner.getId(), key, entry);
		}
		this.data.put(key, entry);
		this.values = null;
		
	}

	public synchronized PersistentAccount get(long key) throws PersistenceException {
		PersistentAccount result = this.data.get(key);
		if (result == null && !this.owner.isDelayed$Persistence()) {
			result = ConnectionHandler.getTheConnectionHandler().theBankFacade.accountsGet(owner.getId(), key);
			if (result != null)
				this.data.put(key, result);
		}
		return result;
	}

	public synchronized void remove(long key) throws PersistenceException {
		
		this.data.remove(key);
		this.values = null;
		if (!this.owner.isDelayed$Persistence()){
			ConnectionHandler.getTheConnectionHandler().theBankFacade.accountsRem(this.owner.getId(), key);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Bank_AccountsProxi copy(Bank owner) throws PersistenceException {
		Bank_AccountsProxi result = new Bank_AccountsProxi(owner);
		result.data = (Hashtable<Long, PersistentAccount>) this.data.clone();
		return result;
	}
	
	public AccountSearchList getValues() throws PersistenceException {
		if (this.values == null) {
			if (this.owner.isDelayed$Persistence()){
				this.values = new AccountSearchList();
				for (PersistentAccount current : this.data.values()) {
					this.values.add(current);
				}
			} else {
				this.values = ConnectionHandler.getTheConnectionHandler().theBankFacade.accountsGetValues(owner.getId());
			}		
		}
		return this.values;
	}
	public void store() throws PersistenceException {
		java.util.Iterator<Long> keys = this.data.keySet().iterator();
		while (keys.hasNext()){
			Long key = keys.next();
			data.get(key).store();
			ConnectionHandler.getTheConnectionHandler().theBankFacade.accountsAdd(owner.getId(), key, data.get(key));
		}
	}
}
