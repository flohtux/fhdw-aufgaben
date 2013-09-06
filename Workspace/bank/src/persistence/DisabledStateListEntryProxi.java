package persistence;

public class DisabledStateListEntryProxi extends DisabledStateProxi implements PersistentDisabledStateListEntryProxi {

  long entryId;

  public DisabledStateListEntryProxi(long objectId, long entryId) {
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