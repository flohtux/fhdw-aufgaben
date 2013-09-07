package persistence;

import java.util.*;

public class BankPxList {

	protected Vector<PersistentBankPx> data; //List of proxies
	protected BankPxList() {
		this.data = new Vector<PersistentBankPx>();
	}
	public Iterator<PersistentBankPx> iterator(PersistentListProxi<PersistentBankPx> listProxi) {
		return new PersistentListIterator<PersistentBankPx>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentBankPx entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected BankPxList copy() {
		BankPxList result = new BankPxList();
		result.data = (Vector<PersistentBankPx>)this.data.clone();
		return result;
	}


}


