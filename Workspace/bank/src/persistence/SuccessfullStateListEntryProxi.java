package persistence;

public class SuccessfullStateListEntryProxi extends SuccessfullStateProxi implements PersistentSuccessfullStateListEntryProxi {

  long entryId;

  public SuccessfullStateListEntryProxi(long objectId, long entryId) {
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