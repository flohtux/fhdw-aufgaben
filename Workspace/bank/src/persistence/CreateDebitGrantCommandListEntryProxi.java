package persistence;

public class CreateDebitGrantCommandListEntryProxi extends CreateDebitGrantCommandProxi implements PersistentCreateDebitGrantCommandListEntryProxi {

  long entryId;

  public CreateDebitGrantCommandListEntryProxi(long objectId, long entryId) {
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