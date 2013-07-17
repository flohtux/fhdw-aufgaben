package persistence;

public class BankServiceSearchList extends SearchListRoot<PersistentBankService> implements Iterable<PersistentBankService> {

	public BankServiceSearchList(SearchListRoot<PersistentBankService> list){
		super(list);
	}
	public BankServiceSearchList(){
		super();
	}
	
	public void add (PersistentBankService entry) {
		this.data.add(entry);
	}
	
	public void add(BankServiceSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentBankService> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentBankService> iterator() {
		return this.data.iterator();
	}
  
}


