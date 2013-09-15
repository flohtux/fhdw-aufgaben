package persistence;

public class RuleSearchList extends SearchListRoot<PersistentRule> implements Iterable<PersistentRule> {

	public RuleSearchList(SearchListRoot<PersistentRule> list){
		super(list);
	}
	public RuleSearchList(){
		super();
	}
	
	public void add (PersistentRule entry) {
		this.data.add(entry);
	}
	
	public void add(RuleSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentRule> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentRule> iterator() {
		return this.data.iterator();
	}
  
}


