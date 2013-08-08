package persistence;

public class AmountSearchList extends SearchListRoot<PersistentAmount> implements Iterable<PersistentAmount> {

	public AmountSearchList(SearchListRoot<PersistentAmount> list){
		super(list);
	}
	public AmountSearchList(){
		super();
	}
	
	public void add (PersistentAmount entry) {
		this.data.add(entry);
	}
	
	public void add(AmountSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentAmount> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentAmount> iterator() {
		return this.data.iterator();
	}
  
}


