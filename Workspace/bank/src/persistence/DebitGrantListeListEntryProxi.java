package persistence;

public class DebitGrantListeListEntryProxi extends DebitGrantListeProxi implements PersistentDebitGrantListeListEntryProxi {

  long entryId;

  public DebitGrantListeListEntryProxi(long objectId, long entryId) {
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