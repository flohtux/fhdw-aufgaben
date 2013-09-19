package persistence;

public class CompensationSearchList extends SearchListRoot<PersistentCompensation> implements Iterable<PersistentCompensation> {

	public CompensationSearchList(SearchListRoot<PersistentCompensation> list){
		super(list);
	}
	public CompensationSearchList(){
		super();
	}
	
	public void add (PersistentCompensation entry) {
		this.data.add(entry);
	}
	
	public void add(CompensationSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentCompensation> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentCompensation> iterator() {
		return this.data.iterator();
	}
  
}


