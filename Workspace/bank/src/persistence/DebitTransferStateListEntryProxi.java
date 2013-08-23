package persistence;

public abstract class DebitTransferStateListEntryProxi extends DebitTransferStateProxi implements PersistentDebitTransferStateListEntryProxi {

  long entryId;

  public DebitTransferStateListEntryProxi(long objectId, long entryId) {
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