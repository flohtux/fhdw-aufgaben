package persistence;

public class AccountServiceSearchList extends SearchListRoot<PersistentAccountService> implements Iterable<PersistentAccountService> {

	public AccountServiceSearchList(SearchListRoot<PersistentAccountService> list){
		super(list);
	}
	public AccountServiceSearchList(){
		super();
	}
	
	public void add (PersistentAccountService entry) {
		this.data.add(entry);
	}
	
	public void add(AccountServiceSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentAccountService> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentAccountService> iterator() {
		return this.data.iterator();
	}
  
}


