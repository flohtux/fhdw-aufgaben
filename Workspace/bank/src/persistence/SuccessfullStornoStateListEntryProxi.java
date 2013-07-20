package persistence;

public class SuccessfullStornoStateListEntryProxi extends SuccessfullStornoStateProxi implements PersistentSuccessfullStornoStateListEntryProxi {

  long entryId;

  public SuccessfullStornoStateListEntryProxi(long objectId, long entryId) {
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