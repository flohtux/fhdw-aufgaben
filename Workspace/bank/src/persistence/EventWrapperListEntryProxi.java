package persistence;

public class EventWrapperListEntryProxi extends EventWrapperProxi implements PersistentEventWrapperListEntryProxi {

  long entryId;

  public EventWrapperListEntryProxi(long objectId, long entryId) {
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