package persistence;

public abstract class DebitTransferListEntryProxi extends DebitTransferProxi implements PersistentDebitTransferListEntryProxi {

  long entryId;

  public DebitTransferListEntryProxi(long objectId, long entryId) {
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