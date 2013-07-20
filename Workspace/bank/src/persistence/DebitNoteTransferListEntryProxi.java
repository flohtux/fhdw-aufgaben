package persistence;

public abstract class DebitNoteTransferListEntryProxi extends DebitNoteTransferProxi implements PersistentDebitNoteTransferListEntryProxi {

  long entryId;

  public DebitNoteTransferListEntryProxi(long objectId, long entryId) {
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