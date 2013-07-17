package persistence;

public class ProcentualFeeListEntryProxi extends ProcentualFeeProxi implements PersistentProcentualFeeListEntryProxi {

  long entryId;

  public ProcentualFeeListEntryProxi(long objectId, long entryId) {
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