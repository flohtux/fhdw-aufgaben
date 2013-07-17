package persistence;

public class DollarListEntryProxi extends DollarProxi implements PersistentDollarListEntryProxi {

  long entryId;

  public DollarListEntryProxi(long objectId, long entryId) {
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