package persistence;

public class TrueValueListEntryProxi extends TrueValueProxi implements PersistentTrueValueListEntryProxi {

  long entryId;

  public TrueValueListEntryProxi(long objectId, long entryId) {
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