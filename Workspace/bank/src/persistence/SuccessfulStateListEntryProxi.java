package persistence;

public class SuccessfulStateListEntryProxi extends SuccessfulStateProxi implements PersistentSuccessfulStateListEntryProxi {

  long entryId;

  public SuccessfulStateListEntryProxi(long objectId, long entryId) {
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