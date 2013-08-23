package persistence;

public class DebitTransferSearchList extends SearchListRoot<PersistentDebitTransfer> implements Iterable<PersistentDebitTransfer> {

	public DebitTransferSearchList(SearchListRoot<PersistentDebitTransfer> list){
		super(list);
	}
	public DebitTransferSearchList(){
		super();
	}
	
	public void add (PersistentDebitTransfer entry) {
		this.data.add(entry);
	}
	
	public void add(DebitTransferSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentDebitTransfer> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentDebitTransfer> iterator() {
		return this.data.iterator();
	}
  
}


