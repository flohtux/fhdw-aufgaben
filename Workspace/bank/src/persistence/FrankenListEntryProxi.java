package persistence;

public class FrankenListEntryProxi extends FrankenProxi implements PersistentFrankenListEntryProxi {

  long entryId;

  public FrankenListEntryProxi(long objectId, long entryId) {
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