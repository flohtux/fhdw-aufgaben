package persistence;

public class MaxLimitStateListEntryProxi extends MaxLimitStateProxi implements PersistentMaxLimitStateListEntryProxi {

  long entryId;

  public MaxLimitStateListEntryProxi(long objectId, long entryId) {
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