package persistence;

public class DebitListEntryProxi extends DebitProxi implements PersistentDebitListEntryProxi {

  long entryId;

  public DebitListEntryProxi(long objectId, long entryId) {
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