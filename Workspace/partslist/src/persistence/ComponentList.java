package persistence;

import java.util.*;

public class ComponentList  extends ComponentSearchList{

	protected ComponentList() {
		super();
	}
	public Iterator<PersistentComponent> iterator(PersistentListProxi<PersistentComponent> listProxi) {
		return new PersistentListIterator<PersistentComponent>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentComponent entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ComponentList copy() {
		ComponentList result = new ComponentList();
		result.data = (Vector<PersistentComponent>)this.data.clone();
		return result;
	}


}


