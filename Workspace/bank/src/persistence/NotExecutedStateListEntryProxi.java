package persistence;

public class NotExecutedStateListEntryProxi extends NotExecutedStateProxi implements PersistentNotExecutedStateListEntryProxi {

  long entryId;

  public NotExecutedStateListEntryProxi(long objectId, long entryId) {
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