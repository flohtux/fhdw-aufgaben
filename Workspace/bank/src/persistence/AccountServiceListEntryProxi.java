package persistence;

public class AccountServiceListEntryProxi extends AccountServiceProxi implements PersistentAccountServiceListEntryProxi {

  long entryId;

  public AccountServiceListEntryProxi(long objectId, long entryId) {
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