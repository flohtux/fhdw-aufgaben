package persistence;

public class CachedListEntryProxi extends CachedProxi implements PersistentCachedListEntryProxi {

  long entryId;

  public CachedListEntryProxi(long objectId, long entryId) {
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