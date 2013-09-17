package persistence;

public class CompensationRequestListEntryProxi extends CompensationRequestProxi implements PersistentCompensationRequestListEntryProxi {

  long entryId;

  public CompensationRequestListEntryProxi(long objectId, long entryId) {
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