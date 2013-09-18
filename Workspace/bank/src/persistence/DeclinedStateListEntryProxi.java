package persistence;

public class DeclinedStateListEntryProxi extends DeclinedStateProxi implements PersistentDeclinedStateListEntryProxi {

  long entryId;

  public DeclinedStateListEntryProxi(long objectId, long entryId) {
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