package persistence;

import java.util.*;

public class ObsInterfaceList {

	protected Vector<ObsInterface> data; //List of proxies
	protected ObsInterfaceList() {
		this.data = new Vector<ObsInterface>();
	}
	public Iterator<ObsInterface> iterator(PersistentListProxi<ObsInterface> listProxi) {
		return new PersistentListIterator<ObsInterface>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (ObsInterface entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ObsInterfaceList copy() {
		ObsInterfaceList result = new ObsInterfaceList();
		result.data = (Vector<ObsInterface>)this.data.clone();
		return result;
	}


}


