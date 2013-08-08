package persistence;

public class SuccessfulStornoStateListEntryProxi extends SuccessfulStornoStateProxi implements PersistentSuccessfulStornoStateListEntryProxi {

  long entryId;

  public SuccessfulStornoStateListEntryProxi(long objectId, long entryId) {
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