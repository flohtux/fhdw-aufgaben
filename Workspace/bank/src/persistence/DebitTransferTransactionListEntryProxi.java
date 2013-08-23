package persistence;

public abstract class DebitTransferTransactionListEntryProxi extends DebitTransferTransactionProxi implements PersistentDebitTransferTransactionListEntryProxi {

  long entryId;

  public DebitTransferTransactionListEntryProxi(long objectId, long entryId) {
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