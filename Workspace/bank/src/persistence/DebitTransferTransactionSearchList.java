package persistence;

public class DebitTransferTransactionSearchList extends SearchListRoot<PersistentDebitTransferTransaction> implements Iterable<PersistentDebitTransferTransaction> {

	public DebitTransferTransactionSearchList(SearchListRoot<PersistentDebitTransferTransaction> list){
		super(list);
	}
	public DebitTransferTransactionSearchList(){
		super();
	}
	
	public void add (PersistentDebitTransferTransaction entry) {
		this.data.add(entry);
	}
	
	public void add(DebitTransferTransactionSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentDebitTransferTransaction> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentDebitTransferTransaction> iterator() {
		return this.data.iterator();
	}
  
}


