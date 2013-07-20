package persistence;

public abstract class StornoStateListEntryProxi extends StornoStateProxi implements PersistentStornoStateListEntryProxi {

  long entryId;

  public StornoStateListEntryProxi(long objectId, long entryId) {
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