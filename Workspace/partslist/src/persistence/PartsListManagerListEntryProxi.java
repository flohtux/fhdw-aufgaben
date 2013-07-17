package persistence;

public class PartsListManagerListEntryProxi extends PartsListManagerProxi implements PersistentPartsListManagerListEntryProxi {

  long entryId;

  public PartsListManagerListEntryProxi(long objectId, long entryId) {
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