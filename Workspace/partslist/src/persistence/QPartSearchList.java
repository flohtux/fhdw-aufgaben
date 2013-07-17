package persistence;

public class QPartSearchList extends SearchListRoot<PersistentQPart> implements Iterable<PersistentQPart> {

	public QPartSearchList(SearchListRoot<PersistentQPart> list){
		super(list);
	}
	public QPartSearchList(){
		super();
	}
	
	public void add (PersistentQPart entry) {
		this.data.add(entry);
	}
	
	public void add(QPartSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentQPart> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentQPart> iterator() {
		return this.data.iterator();
	}
  
}


