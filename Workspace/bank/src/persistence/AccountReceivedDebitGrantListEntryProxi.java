package persistence;

public class AccountReceivedDebitGrantListEntryProxi extends AccountReceivedDebitGrantProxi implements PersistentAccountReceivedDebitGrantListEntryProxi {

  long entryId;

  public AccountReceivedDebitGrantListEntryProxi(long objectId, long entryId) {
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