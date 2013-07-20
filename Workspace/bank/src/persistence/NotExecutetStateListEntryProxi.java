package persistence;

public class NotExecutetStateListEntryProxi extends NotExecutetStateProxi implements PersistentNotExecutetStateListEntryProxi {

  long entryId;

  public NotExecutetStateListEntryProxi(long objectId, long entryId) {
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