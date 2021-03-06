package persistence;

public class TriggerListEntryProxi extends TriggerProxi implements PersistentTriggerListEntryProxi {

  long entryId;

  public TriggerListEntryProxi(long objectId, long entryId) {
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