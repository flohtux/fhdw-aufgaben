package persistence;

public class BankCreatorListEntryProxi extends BankCreatorProxi implements PersistentBankCreatorListEntryProxi {

  long entryId;

  public BankCreatorListEntryProxi(long objectId, long entryId) {
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