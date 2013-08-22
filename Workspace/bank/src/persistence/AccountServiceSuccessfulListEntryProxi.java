package persistence;

public class AccountServiceSuccessfulListEntryProxi extends AccountServiceSuccessfulProxi implements PersistentAccountServiceSuccessfulListEntryProxi {

  long entryId;

  public AccountServiceSuccessfulListEntryProxi(long objectId, long entryId) {
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