package persistence;

public class AddComponentCommandListEntryProxi extends AddComponentCommandProxi implements PersistentAddComponentCommandListEntryProxi {

  long entryId;

  public AddComponentCommandListEntryProxi(long objectId, long entryId) {
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