package persistence;

public class BankServiceListEntryProxi extends BankServiceProxi implements PersistentBankServiceListEntryProxi {

  long entryId;

  public BankServiceListEntryProxi(long objectId, long entryId) {
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