package persistence;

public class PercentListEntryProxi extends PercentProxi implements PersistentPercentListEntryProxi {

  long entryId;

  public PercentListEntryProxi(long objectId, long entryId) {
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