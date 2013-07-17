package persistence;

import java.util.*;

public class BankList  extends BankSearchList{

	protected BankList() {
		super();
	}
	public Iterator<PersistentBank> iterator(PersistentListProxi<PersistentBank> listProxi) {
		return new PersistentListIterator<PersistentBank>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentBank entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected BankList copy() {
		BankList result = new BankList();
		result.data = (Vector<PersistentBank>)this.data.clone();
		return result;
	}


}


