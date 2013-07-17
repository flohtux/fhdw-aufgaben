package persistence;

import model.*;

import java.util.Iterator;

public class Bank_CurrentAccountsProxi extends PersistentListProxi<PersistentAccount> {

  	private AccountList list;

  	public Bank_CurrentAccountsProxi(Bank owner) {
  	}
  	public AccountList getList() throws PersistenceException{
    	if (this.list == null) {
      		this.list = new AccountList();
    	}
    	return this.list;
  	}
  	public Iterator<PersistentAccount> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
		return this.getList().getLength();
  	}
  	public void add(PersistentAccount entry) throws PersistenceException {
    	if (entry != null) {
      		AccountList list = this.getList();
      		list.add((PersistentAccount)PersistentProxi.createListEntryProxi(entry.getId(),
                               			entry.getClassId(),
                               			-1));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
  	}
  	public Bank_CurrentAccountsProxi copy(Bank owner) throws PersistenceException {
  		Bank_CurrentAccountsProxi result = new Bank_CurrentAccountsProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	} 
  	public void store(){}
  
}
