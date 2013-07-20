package persistence;

public class FalseValueListEntryProxi extends FalseValueProxi implements PersistentFalseValueListEntryProxi {

  long entryId;

  public FalseValueListEntryProxi(long objectId, long entryId) {
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