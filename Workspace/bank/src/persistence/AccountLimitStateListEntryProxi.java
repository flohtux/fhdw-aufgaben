package persistence;

public abstract class AccountLimitStateListEntryProxi extends AccountLimitStateProxi implements PersistentAccountLimitStateListEntryProxi {

  long entryId;

  public AccountLimitStateListEntryProxi(long objectId, long entryId) {
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