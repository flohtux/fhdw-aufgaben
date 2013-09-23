package persistence;

public class NoDebitTransferListEntryProxi extends NoDebitTransferProxi implements PersistentNoDebitTransferListEntryProxi {

  long entryId;

  public NoDebitTransferListEntryProxi(long objectId, long entryId) {
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