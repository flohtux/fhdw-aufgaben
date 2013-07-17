package persistence;

import java.util.*;

public class MateriallistValueList {

	protected Vector<PersistentMateriallistValue> data; //List of proxies
	protected MateriallistValueList() {
		this.data = new Vector<PersistentMateriallistValue>();
	}
	public Iterator<PersistentMateriallistValue> iterator(PersistentListProxi<PersistentMateriallistValue> listProxi) {
		return new PersistentListIterator<PersistentMateriallistValue>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentMateriallistValue entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected MateriallistValueList copy() {
		MateriallistValueList result = new MateriallistValueList();
		result.data = (Vector<PersistentMateriallistValue>)this.data.clone();
		return result;
	}


}


