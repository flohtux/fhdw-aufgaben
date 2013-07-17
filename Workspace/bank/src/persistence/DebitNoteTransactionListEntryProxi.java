package persistence;

public abstract class DebitNoteTransactionListEntryProxi extends DebitNoteTransactionProxi implements PersistentDebitNoteTransactionListEntryProxi {

  long entryId;

  public DebitNoteTransactionListEntryProxi(long objectId, long entryId) {
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