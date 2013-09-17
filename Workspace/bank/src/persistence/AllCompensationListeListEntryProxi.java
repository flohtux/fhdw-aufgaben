package persistence;

public class AllCompensationListeListEntryProxi extends AllCompensationListeProxi implements PersistentAllCompensationListeListEntryProxi {

  long entryId;

  public AllCompensationListeListEntryProxi(long objectId, long entryId) {
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