package persistence;

public abstract class LimitTypeListEntryProxi extends LimitTypeProxi implements PersistentLimitTypeListEntryProxi {

  long entryId;

  public LimitTypeListEntryProxi(long objectId, long entryId) {
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