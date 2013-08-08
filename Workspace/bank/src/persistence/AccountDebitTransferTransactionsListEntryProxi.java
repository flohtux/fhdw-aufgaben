package persistence;

public class AccountDebitTransferTransactionsListEntryProxi extends AccountDebitTransferTransactionsProxi implements PersistentAccountDebitTransferTransactionsListEntryProxi {

  long entryId;

  public AccountDebitTransferTransactionsListEntryProxi(long objectId, long entryId) {
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