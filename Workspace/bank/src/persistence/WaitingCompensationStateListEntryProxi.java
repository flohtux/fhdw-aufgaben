package persistence;

public class WaitingCompensationStateListEntryProxi extends WaitingCompensationStateProxi implements PersistentWaitingCompensationStateListEntryProxi {

  long entryId;

  public WaitingCompensationStateListEntryProxi(long objectId, long entryId) {
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