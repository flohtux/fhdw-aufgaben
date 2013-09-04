package persistence;

public class TriggerListeListEntryProxi extends TriggerListeProxi implements PersistentTriggerListeListEntryProxi {

  long entryId;

  public TriggerListeListEntryProxi(long objectId, long entryId) {
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