package persistence;

public class ComponentSearchList extends SearchListRoot<PersistentComponent> implements Iterable<PersistentComponent> {

	public ComponentSearchList(SearchListRoot<PersistentComponent> list){
		super(list);
	}
	public ComponentSearchList(){
		super();
	}
	
	public void add (PersistentComponent entry) {
		this.data.add(entry);
	}
	
	public void add(ComponentSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentComponent> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentComponent> iterator() {
		return this.data.iterator();
	}
  
}


