package persistence;

public class AccountDebitNoteTransferTransactionsListEntryProxi extends AccountDebitNoteTransferTransactionsProxi implements PersistentAccountDebitNoteTransferTransactionsListEntryProxi {

  long entryId;

  public AccountDebitNoteTransferTransactionsListEntryProxi(long objectId, long entryId) {
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