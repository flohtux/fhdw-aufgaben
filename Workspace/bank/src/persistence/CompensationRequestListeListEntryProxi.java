package persistence;

public class CompensationRequestListeListEntryProxi extends CompensationRequestListeProxi implements PersistentCompensationRequestListeListEntryProxi {

  long entryId;

  public CompensationRequestListeListEntryProxi(long objectId, long entryId) {
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