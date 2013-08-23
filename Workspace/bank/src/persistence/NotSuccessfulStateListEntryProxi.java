package persistence;

public class NotSuccessfulStateListEntryProxi extends NotSuccessfulStateProxi implements PersistentNotSuccessfulStateListEntryProxi {

  long entryId;

  public NotSuccessfulStateListEntryProxi(long objectId, long entryId) {
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