package persistence;

public class NotExecutableStateListEntryProxi extends NotExecutableStateProxi implements PersistentNotExecutableStateListEntryProxi {

  long entryId;

  public NotExecutableStateListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }
  public void setListEntryId(long id){
	this.entryId = id;  
  }

}