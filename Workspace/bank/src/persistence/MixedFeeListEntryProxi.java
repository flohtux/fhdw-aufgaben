package persistence;

public class MixedFeeListEntryProxi extends MixedFeeProxi implements PersistentMixedFeeListEntryProxi {

  long entryId;

  public MixedFeeListEntryProxi(long objectId, long entryId) {
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