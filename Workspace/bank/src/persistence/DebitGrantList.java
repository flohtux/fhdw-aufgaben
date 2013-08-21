package persistence;

import java.util.*;

public class DebitGrantList {

	protected Vector<PersistentDebitGrant> data; //List of proxies
	protected DebitGrantList() {
		this.data = new Vector<PersistentDebitGrant>();
	}
	public Iterator<PersistentDebitGrant> iterator(PersistentListProxi<PersistentDebitGrant> listProxi) {
		return new PersistentListIterator<PersistentDebitGrant>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentDebitGrant entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected DebitGrantList copy() {
		DebitGrantList result = new DebitGrantList();
		result.data = (Vector<PersistentDebitGrant>)this.data.clone();
		return result;
	}


}


