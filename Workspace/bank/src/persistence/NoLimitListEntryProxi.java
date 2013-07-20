package persistence;

public class NoLimitListEntryProxi extends NoLimitProxi implements PersistentNoLimitListEntryProxi {

  long entryId;

  public NoLimitListEntryProxi(long objectId, long entryId) {
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