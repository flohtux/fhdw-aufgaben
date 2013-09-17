package persistence;

public class BankOwnAccountPxListEntryProxi extends BankOwnAccountPxProxi implements PersistentBankOwnAccountPxListEntryProxi {

  long entryId;

  public BankOwnAccountPxListEntryProxi(long objectId, long entryId) {
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