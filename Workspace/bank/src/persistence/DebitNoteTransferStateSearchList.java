package persistence;

public class DebitNoteTransferStateSearchList extends SearchListRoot<PersistentDebitNoteTransferState> implements Iterable<PersistentDebitNoteTransferState> {

	public DebitNoteTransferStateSearchList(SearchListRoot<PersistentDebitNoteTransferState> list){
		super(list);
	}
	public DebitNoteTransferStateSearchList(){
		super();
	}
	
	public void add (PersistentDebitNoteTransferState entry) {
		this.data.add(entry);
	}
	
	public void add(DebitNoteTransferStateSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentDebitNoteTransferState> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentDebitNoteTransferState> iterator() {
		return this.data.iterator();
	}
  
}


