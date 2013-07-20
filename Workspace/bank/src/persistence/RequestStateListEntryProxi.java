package persistence;

public class RequestStateListEntryProxi extends RequestStateProxi implements PersistentRequestStateListEntryProxi {

  long entryId;

  public RequestStateListEntryProxi(long objectId, long entryId) {
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