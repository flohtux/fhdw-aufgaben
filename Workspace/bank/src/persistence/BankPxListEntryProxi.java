package persistence;

public class BankPxListEntryProxi extends BankPxProxi implements PersistentBankPxListEntryProxi {

  long entryId;

  public BankPxListEntryProxi(long objectId, long entryId) {
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