package persistence;

import java.util.*;

public class DebitTransferTransactionList  extends DebitTransferTransactionSearchList{

	protected DebitTransferTransactionList() {
		super();
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


