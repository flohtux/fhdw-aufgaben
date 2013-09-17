package persistence;

public class CompensationListeListEntryProxi extends CompensationListeProxi implements PersistentCompensationListeListEntryProxi {

  long entryId;

  public CompensationListeListEntryProxi(long objectId, long entryId) {
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