package persistence;

public abstract class TriggerValueListEntryProxi extends TriggerValueProxi implements PersistentTriggerValueListEntryProxi {

  long entryId;

  public TriggerValueListEntryProxi(long objectId, long entryId) {
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