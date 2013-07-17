package persistence;

public class BankListEntryProxi extends BankProxi implements PersistentBankListEntryProxi {

  long entryId;

  public BankListEntryProxi(long objectId, long entryId) {
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