package persistence;

import java.util.*;

public class RuleList  extends RuleSearchList{

	protected RuleList() {
		super();
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


