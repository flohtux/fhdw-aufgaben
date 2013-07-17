package persistence;

public class EuroListEntryProxi extends EuroProxi implements PersistentEuroListEntryProxi {

  long entryId;

  public EuroListEntryProxi(long objectId, long entryId) {
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