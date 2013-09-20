package persistence;

import java.util.*;

public class ExchangeRateWrapperList {

	protected Vector<PersistentExchangeRateWrapper> data; //List of proxies
	protected ExchangeRateWrapperList() {
		this.data = new Vector<PersistentExchangeRateWrapper>();
	}
	public Iterator<PersistentExchangeRateWrapper> iterator(PersistentListProxi<PersistentExchangeRateWrapper> listProxi) {
		return new PersistentListIterator<PersistentExchangeRateWrapper>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentExchangeRateWrapper entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected ExchangeRateWrapperList copy() {
		ExchangeRateWrapperList result = new ExchangeRateWrapperList();
		result.data = (Vector<PersistentExchangeRateWrapper>)this.data.clone();
		return result;
	}


}


