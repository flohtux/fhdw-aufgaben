package persistence;

public abstract class TransactionFeeListEntryProxi extends TransactionFeeProxi implements PersistentTransactionFeeListEntryProxi {

  long entryId;

  public TransactionFeeListEntryProxi(long objectId, long entryId) {
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