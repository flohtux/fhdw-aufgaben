package persistence;

public class LimitListEntryProxi extends LimitProxi implements PersistentLimitListEntryProxi {

  long entryId;

  public LimitListEntryProxi(long objectId, long entryId) {
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