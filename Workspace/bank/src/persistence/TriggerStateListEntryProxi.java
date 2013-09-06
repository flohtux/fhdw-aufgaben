package persistence;

public abstract class TriggerStateListEntryProxi extends TriggerStateProxi implements PersistentTriggerStateListEntryProxi {

  long entryId;

  public TriggerStateListEntryProxi(long objectId, long entryId) {
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