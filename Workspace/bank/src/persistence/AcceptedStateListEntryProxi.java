package persistence;

public class AcceptedStateListEntryProxi extends AcceptedStateProxi implements PersistentAcceptedStateListEntryProxi {

  long entryId;

  public AcceptedStateListEntryProxi(long objectId, long entryId) {
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