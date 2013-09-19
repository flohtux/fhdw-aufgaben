package persistence;

public class CompensationDeclinedCommandListEntryProxi extends CompensationDeclinedCommandProxi implements PersistentCompensationDeclinedCommandListEntryProxi {

  long entryId;

  public CompensationDeclinedCommandListEntryProxi(long objectId, long entryId) {
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