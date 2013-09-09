package persistence;

public class NoTriggerListEntryProxi extends NoTriggerProxi implements PersistentNoTriggerListEntryProxi {

  long entryId;

  public NoTriggerListEntryProxi(long objectId, long entryId) {
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