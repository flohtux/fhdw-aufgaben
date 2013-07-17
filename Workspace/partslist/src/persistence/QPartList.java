package persistence;

import java.util.*;

public class QPartList  extends QPartSearchList{

	protected QPartList() {
		super();
	}
	public Iterator<PersistentQPart> iterator(PersistentListProxi<PersistentQPart> listProxi) {
		return new PersistentListIterator<PersistentQPart>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentQPart entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected QPartList copy() {
		QPartList result = new QPartList();
		result.data = (Vector<PersistentQPart>)this.data.clone();
		return result;
	}


}


