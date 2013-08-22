package persistence;

import java.util.*;

public class DebitTransferList  extends DebitTransferSearchList{

	protected DebitTransferList() {
		super();
	}
	public Iterator<PersistentDebitTransfer> iterator(PersistentListProxi<PersistentDebitTransfer> listProxi) {
		return new PersistentListIterator<PersistentDebitTransfer>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentDebitTransfer entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected DebitTransferList copy() {
		DebitTransferList result = new DebitTransferList();
		result.data = (Vector<PersistentDebitTransfer>)this.data.clone();
		return result;
	}


}


