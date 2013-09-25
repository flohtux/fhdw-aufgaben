package persistence;

public class CompensationRequestedStateListEntryProxi extends CompensationRequestedStateProxi implements PersistentCompensationRequestedStateListEntryProxi {

  long entryId;

  public CompensationRequestedStateListEntryProxi(long objectId, long entryId) {
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