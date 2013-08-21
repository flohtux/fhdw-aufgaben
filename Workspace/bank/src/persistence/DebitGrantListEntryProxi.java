package persistence;

public class DebitGrantListEntryProxi extends DebitGrantProxi implements PersistentDebitGrantListEntryProxi {

  long entryId;

  public DebitGrantListEntryProxi(long objectId, long entryId) {
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