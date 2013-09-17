package persistence;

import java.util.*;

public class CompensationRequestList {

	protected Vector<PersistentCompensationRequest> data; //List of proxies
	protected CompensationRequestList() {
		this.data = new Vector<PersistentCompensationRequest>();
	}
	public Iterator<PersistentCompensationRequest> iterator(PersistentListProxi<PersistentCompensationRequest> listProxi) {
		return new PersistentListIterator<PersistentCompensationRequest>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentCompensationRequest entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected CompensationRequestList copy() {
		CompensationRequestList result = new CompensationRequestList();
		result.data = (Vector<PersistentCompensationRequest>)this.data.clone();
		return result;
	}


}


