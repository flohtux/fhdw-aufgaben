package persistence;

public class AllCompensationListeOutgoingCompensationsListEntryProxi extends AllCompensationListeOutgoingCompensationsProxi implements PersistentAllCompensationListeOutgoingCompensationsListEntryProxi {

  long entryId;

  public AllCompensationListeOutgoingCompensationsListEntryProxi(long objectId, long entryId) {
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