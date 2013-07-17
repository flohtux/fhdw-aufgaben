package persistence;

public class DebitNoteListEntryProxi extends DebitNoteProxi implements PersistentDebitNoteListEntryProxi {

  long entryId;

  public DebitNoteListEntryProxi(long objectId, long entryId) {
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