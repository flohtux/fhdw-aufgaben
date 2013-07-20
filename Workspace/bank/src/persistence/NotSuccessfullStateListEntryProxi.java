package persistence;

public class NotSuccessfullStateListEntryProxi extends NotSuccessfullStateProxi implements PersistentNotSuccessfullStateListEntryProxi {

  long entryId;

  public NotSuccessfullStateListEntryProxi(long objectId, long entryId) {
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