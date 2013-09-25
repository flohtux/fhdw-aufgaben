package persistence;

public class DeclinedCompensationStateListEntryProxi extends DeclinedCompensationStateProxi implements PersistentDeclinedCompensationStateListEntryProxi {

  long entryId;

  public DeclinedCompensationStateListEntryProxi(long objectId, long entryId) {
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