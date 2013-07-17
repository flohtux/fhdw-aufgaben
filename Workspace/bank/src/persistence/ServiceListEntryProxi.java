package persistence;

public abstract class ServiceListEntryProxi extends ServiceProxi implements PersistentServiceListEntryProxi {

  long entryId;

  public ServiceListEntryProxi(long objectId, long entryId) {
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