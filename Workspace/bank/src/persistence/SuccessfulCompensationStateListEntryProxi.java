package persistence;

public class SuccessfulCompensationStateListEntryProxi extends SuccessfulCompensationStateProxi implements PersistentSuccessfulCompensationStateListEntryProxi {

  long entryId;

  public SuccessfulCompensationStateListEntryProxi(long objectId, long entryId) {
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