package persistence;

public class TrancactionListEntryProxi extends TrancactionProxi implements PersistentTrancactionListEntryProxi {

  long entryId;

  public TrancactionListEntryProxi(long objectId, long entryId) {
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