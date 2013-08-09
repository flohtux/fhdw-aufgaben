package persistence;

public class PfundListEntryProxi extends PfundProxi implements PersistentPfundListEntryProxi {

  long entryId;

  public PfundListEntryProxi(long objectId, long entryId) {
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