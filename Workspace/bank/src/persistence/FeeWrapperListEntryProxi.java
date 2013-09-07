package persistence;

public class FeeWrapperListEntryProxi extends FeeWrapperProxi implements PersistentFeeWrapperListEntryProxi {

  long entryId;

  public FeeWrapperListEntryProxi(long objectId, long entryId) {
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