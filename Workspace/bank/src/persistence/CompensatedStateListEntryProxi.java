package persistence;

public class CompensatedStateListEntryProxi extends CompensatedStateProxi implements PersistentCompensatedStateListEntryProxi {

  long entryId;

  public CompensatedStateListEntryProxi(long objectId, long entryId) {
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