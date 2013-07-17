package persistence;

import java.util.*;

public class AccountList  extends AccountSearchList{

	protected AccountList() {
		super();
	}
	public Iterator<PersistentAccount> iterator(PersistentListProxi<PersistentAccount> listProxi) {
		return new PersistentListIterator<PersistentAccount>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentAccount entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected AccountList copy() {
		AccountList result = new AccountList();
		result.data = (Vector<PersistentAccount>)this.data.clone();
		return result;
	}


}


