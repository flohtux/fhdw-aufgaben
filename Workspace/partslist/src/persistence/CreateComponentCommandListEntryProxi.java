package persistence;

public class CreateComponentCommandListEntryProxi extends CreateComponentCommandProxi implements PersistentCreateComponentCommandListEntryProxi {

  long entryId;

  public CreateComponentCommandListEntryProxi(long objectId, long entryId) {
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