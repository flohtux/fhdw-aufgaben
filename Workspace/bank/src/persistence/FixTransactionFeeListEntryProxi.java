package persistence;

public class FixTransactionFeeListEntryProxi extends FixTransactionFeeProxi implements PersistentFixTransactionFeeListEntryProxi {

  long entryId;

  public FixTransactionFeeListEntryProxi(long objectId, long entryId) {
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