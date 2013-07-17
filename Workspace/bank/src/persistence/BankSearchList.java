package persistence;

public class BankSearchList extends SearchListRoot<PersistentBank> implements Iterable<PersistentBank> {

	public BankSearchList(SearchListRoot<PersistentBank> list){
		super(list);
	}
	public BankSearchList(){
		super();
	}
	
	public void add (PersistentBank entry) {
		this.data.add(entry);
	}
	
	public void add(BankSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentBank> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentBank> iterator() {
		return this.data.iterator();
	}
  
}


