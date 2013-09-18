package persistence;

public class WaitingStateListEntryProxi extends WaitingStateProxi implements PersistentWaitingStateListEntryProxi {

  long entryId;

  public WaitingStateListEntryProxi(long objectId, long entryId) {
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