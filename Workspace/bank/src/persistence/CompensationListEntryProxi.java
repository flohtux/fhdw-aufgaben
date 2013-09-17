package persistence;

public class CompensationListEntryProxi extends CompensationProxi implements PersistentCompensationListEntryProxi {

  long entryId;

  public CompensationListEntryProxi(long objectId, long entryId) {
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