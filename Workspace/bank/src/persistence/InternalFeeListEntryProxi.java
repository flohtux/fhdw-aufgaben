package persistence;

public class InternalFeeListEntryProxi extends InternalFeeProxi implements PersistentInternalFeeListEntryProxi {

  long entryId;

  public InternalFeeListEntryProxi(long objectId, long entryId) {
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