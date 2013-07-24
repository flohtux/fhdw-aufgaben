package persistence;

import java.util.*;

public class DebitNoteTransferTransactionList {

	protected Vector<PersistentDebitNoteTransferTransaction> data; //List of proxies
	protected DebitNoteTransferTransactionList() {
		this.data = new Vector<PersistentDebitNoteTransferTransaction>();
	}
	public Iterator<PersistentDebitNoteTransferTransaction> iterator(PersistentListProxi<PersistentDebitNoteTransferTransaction> listProxi) {
		return new PersistentListIterator<PersistentDebitNoteTransferTransaction>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentDebitNoteTransferTransaction entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected DebitNoteTransferTransactionList copy() {
		DebitNoteTransferTransactionList result = new DebitNoteTransferTransactionList();
		result.data = (Vector<PersistentDebitNoteTransferTransaction>)this.data.clone();
		return result;
	}


}


