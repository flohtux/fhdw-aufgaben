package persistence;

public class TransferListEntryProxi extends TransferProxi implements PersistentTransferListEntryProxi {

  long entryId;

  public TransferListEntryProxi(long objectId, long entryId) {
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