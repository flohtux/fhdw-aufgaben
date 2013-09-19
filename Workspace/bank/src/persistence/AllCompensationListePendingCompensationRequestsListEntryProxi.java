package persistence;

public class AllCompensationListePendingCompensationRequestsListEntryProxi extends AllCompensationListePendingCompensationRequestsProxi implements PersistentAllCompensationListePendingCompensationRequestsListEntryProxi {

  long entryId;

  public AllCompensationListePendingCompensationRequestsListEntryProxi(long objectId, long entryId) {
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