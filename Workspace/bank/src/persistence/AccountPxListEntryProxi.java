package persistence;

public class AccountPxListEntryProxi extends AccountPxProxi implements PersistentAccountPxListEntryProxi {

  long entryId;

  public AccountPxListEntryProxi(long objectId, long entryId) {
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