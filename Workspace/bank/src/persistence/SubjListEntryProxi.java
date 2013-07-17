package persistence;

public class SubjListEntryProxi extends SubjProxi implements PersistentSubjListEntryProxi {

  long entryId;

  public SubjListEntryProxi(long objectId, long entryId) {
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