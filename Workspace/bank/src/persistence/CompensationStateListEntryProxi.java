package persistence;

public abstract class CompensationStateListEntryProxi extends CompensationStateProxi implements PersistentCompensationStateListEntryProxi {

  long entryId;

  public CompensationStateListEntryProxi(long objectId, long entryId) {
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