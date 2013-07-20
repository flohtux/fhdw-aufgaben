package persistence;

public class ExecutedStateListEntryProxi extends ExecutedStateProxi implements PersistentExecutedStateListEntryProxi {

  long entryId;

  public ExecutedStateListEntryProxi(long objectId, long entryId) {
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