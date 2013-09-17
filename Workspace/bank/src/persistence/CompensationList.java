package persistence;

import java.util.*;

public class CompensationList {

	protected Vector<PersistentCompensation> data; //List of proxies
	protected CompensationList() {
		this.data = new Vector<PersistentCompensation>();
	}
	public Iterator<PersistentCompensation> iterator(PersistentListProxi<PersistentCompensation> listProxi) {
		return new PersistentListIterator<PersistentCompensation>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentCompensation entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected CompensationList copy() {
		CompensationList result = new CompensationList();
		result.data = (Vector<PersistentCompensation>)this.data.clone();
		return result;
	}


}


