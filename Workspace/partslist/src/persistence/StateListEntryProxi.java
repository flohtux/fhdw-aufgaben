package persistence;

public abstract class StateListEntryProxi extends StateProxi implements PersistentStateListEntryProxi {

  long entryId;

  public StateListEntryProxi(long objectId, long entryId) {
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