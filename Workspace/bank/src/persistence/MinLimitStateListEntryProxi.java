package persistence;

public class MinLimitStateListEntryProxi extends MinLimitStateProxi implements PersistentMinLimitStateListEntryProxi {

  long entryId;

  public MinLimitStateListEntryProxi(long objectId, long entryId) {
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