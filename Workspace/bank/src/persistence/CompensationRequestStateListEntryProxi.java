package persistence;

public class CompensationRequestStateListEntryProxi extends CompensationRequestStateProxi implements PersistentCompensationRequestStateListEntryProxi {

  long entryId;

  public CompensationRequestStateListEntryProxi(long objectId, long entryId) {
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