package persistence;

import java.util.*;

public class TriggerList {

	protected Vector<PersistentTrigger> data; //List of proxies
	protected TriggerList() {
		this.data = new Vector<PersistentTrigger>();
	}
	public Iterator<PersistentTrigger> iterator(PersistentListProxi<PersistentTrigger> listProxi) {
		return new PersistentListIterator<PersistentTrigger>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentTrigger entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected TriggerList copy() {
		TriggerList result = new TriggerList();
		result.data = (Vector<PersistentTrigger>)this.data.clone();
		return result;
	}


}


