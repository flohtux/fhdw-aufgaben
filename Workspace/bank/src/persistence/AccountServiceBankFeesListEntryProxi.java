package persistence;

public class AccountServiceBankFeesListEntryProxi extends AccountServiceBankFeesProxi implements PersistentAccountServiceBankFeesListEntryProxi {

  long entryId;

  public AccountServiceBankFeesListEntryProxi(long objectId, long entryId) {
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