package persistence;

public class BankFeesListEntryProxi extends BankFeesProxi implements PersistentBankFeesListEntryProxi {

  long entryId;

  public BankFeesListEntryProxi(long objectId, long entryId) {
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