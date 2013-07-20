package persistence;

public abstract class DebitNoteTransferStateListEntryProxi extends DebitNoteTransferStateProxi implements PersistentDebitNoteTransferStateListEntryProxi {

  long entryId;

  public DebitNoteTransferStateListEntryProxi(long objectId, long entryId) {
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