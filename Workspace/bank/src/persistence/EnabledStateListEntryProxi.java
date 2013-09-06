package persistence;

public class EnabledStateListEntryProxi extends EnabledStateProxi implements PersistentEnabledStateListEntryProxi {

  long entryId;

  public EnabledStateListEntryProxi(long objectId, long entryId) {
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