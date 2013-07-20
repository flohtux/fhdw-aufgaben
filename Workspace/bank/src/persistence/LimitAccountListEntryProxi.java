package persistence;

public class LimitAccountListEntryProxi extends LimitAccountProxi implements PersistentLimitAccountListEntryProxi {

  long entryId;

  public LimitAccountListEntryProxi(long objectId, long entryId) {
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