package persistence;

public class DebitGrantListePxListEntryProxi extends DebitGrantListePxProxi implements PersistentDebitGrantListePxListEntryProxi {

  long entryId;

  public DebitGrantListePxListEntryProxi(long objectId, long entryId) {
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