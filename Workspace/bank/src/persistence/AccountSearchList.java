package persistence;

public class AccountSearchList extends SearchListRoot<PersistentAccount> implements Iterable<PersistentAccount> {

	public AccountSearchList(SearchListRoot<PersistentAccount> list){
		super(list);
	}
	public AccountSearchList(){
		super();
	}
	
	public void add (PersistentAccount entry) {
		this.data.add(entry);
	}
	
	public void add(AccountSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentAccount> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentAccount> iterator() {
		return this.data.iterator();
	}
  
}


