package persistence;

public class TriggerSearchList extends SearchListRoot<PersistentTrigger> implements Iterable<PersistentTrigger> {

	public TriggerSearchList(SearchListRoot<PersistentTrigger> list){
		super(list);
	}
	public TriggerSearchList(){
		super();
	}
	
	public void add (PersistentTrigger entry) {
		this.data.add(entry);
	}
	
	public void add(TriggerSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentTrigger> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentTrigger> iterator() {
		return this.data.iterator();
	}
  
}


