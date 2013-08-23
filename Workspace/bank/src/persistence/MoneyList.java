package persistence;

import java.util.*;

public class MoneyList {

	protected Vector<PersistentMoney> data; //List of proxies
	protected MoneyList() {
		this.data = new Vector<PersistentMoney>();
	}
	public Iterator<PersistentMoney> iterator(PersistentListProxi<PersistentMoney> listProxi) {
		return new PersistentListIterator<PersistentMoney>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMoney entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MoneyList copy() {
		MoneyList result = new MoneyList();
		result.data = (Vector<PersistentMoney>)this.data.clone();
		return result;
	}


}


