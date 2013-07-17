package persistence;

public class NotCachedListEntryProxi extends NotCachedProxi implements PersistentNotCachedListEntryProxi {

  long entryId;

  public NotCachedListEntryProxi(long objectId, long entryId) {
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