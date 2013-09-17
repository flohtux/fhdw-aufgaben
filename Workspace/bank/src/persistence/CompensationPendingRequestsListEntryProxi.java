package persistence;

public class CompensationPendingRequestsListEntryProxi extends CompensationPendingRequestsProxi implements PersistentCompensationPendingRequestsListEntryProxi {

  long entryId;

  public CompensationPendingRequestsListEntryProxi(long objectId, long entryId) {
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