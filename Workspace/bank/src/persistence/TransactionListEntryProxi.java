package persistence;

public class TransactionListEntryProxi extends TransactionProxi implements PersistentTransactionListEntryProxi {

  long entryId;

  public TransactionListEntryProxi(long objectId, long entryId) {
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