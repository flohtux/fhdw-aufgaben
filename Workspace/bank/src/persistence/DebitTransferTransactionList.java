package persistence;

import java.util.*;

public class DebitTransferTransactionList {

	protected Vector<PersistentDebitTransferTransaction> data; //List of proxies
	protected DebitTransferTransactionList() {
		this.data = new Vector<PersistentDebitTransferTransaction>();
	}
	public Iterator<PersistentDebitTransferTransaction> iterator(PersistentListProxi<PersistentDebitTransferTransaction> listProxi) {
		return new PersistentListIterator<PersistentDebitTransferTransaction>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentDebitTransferTransaction entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected DebitTransferTransactionList copy() {
		DebitTransferTransactionList result = new DebitTransferTransactionList();
		result.data = (Vector<PersistentDebitTransferTransaction>)this.data.clone();
		return result;
	}


}


