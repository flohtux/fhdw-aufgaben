package persistence;

public class NoLimitStateListEntryProxi extends NoLimitStateProxi implements PersistentNoLimitStateListEntryProxi {

  long entryId;

  public NoLimitStateListEntryProxi(long objectId, long entryId) {
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