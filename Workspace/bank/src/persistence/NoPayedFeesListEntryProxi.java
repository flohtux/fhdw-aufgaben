package persistence;

public class NoPayedFeesListEntryProxi extends NoPayedFeesProxi implements PersistentNoPayedFeesListEntryProxi {

  long entryId;

  public NoPayedFeesListEntryProxi(long objectId, long entryId) {
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