package persistence;

import java.util.*;

public class RuleList {

	protected Vector<PersistentRule> data; //List of proxies
	protected RuleList() {
		this.data = new Vector<PersistentRule>();
	}
	public Iterator<PersistentRule> iterator(PersistentListProxi<PersistentRule> listProxi) {
		return new PersistentListIterator<PersistentRule>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentRule entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected RuleList copy() {
		RuleList result = new RuleList();
		result.data = (Vector<PersistentRule>)this.data.clone();
		return result;
	}


}


