package persistence;

public class DebitNoteTransferSearchList extends SearchListRoot<PersistentDebitNoteTransfer> implements Iterable<PersistentDebitNoteTransfer> {

	public DebitNoteTransferSearchList(SearchListRoot<PersistentDebitNoteTransfer> list){
		super(list);
	}
	public DebitNoteTransferSearchList(){
		super();
	}
	
	public void add (PersistentDebitNoteTransfer entry) {
		this.data.add(entry);
	}
	
	public void add(DebitNoteTransferSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentDebitNoteTransfer> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentDebitNoteTransfer> iterator() {
		return this.data.iterator();
	}
  
}


