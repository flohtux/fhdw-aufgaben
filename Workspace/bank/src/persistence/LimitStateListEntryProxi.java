package persistence;

public abstract class LimitStateListEntryProxi extends LimitStateProxi implements PersistentLimitStateListEntryProxi {

  long entryId;

  public LimitStateListEntryProxi(long objectId, long entryId) {
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