package persistence;

public abstract class DebitNoteTransferTransactionListEntryProxi extends DebitNoteTransferTransactionProxi implements PersistentDebitNoteTransferTransactionListEntryProxi {

  long entryId;

  public DebitNoteTransferTransactionListEntryProxi(long objectId, long entryId) {
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