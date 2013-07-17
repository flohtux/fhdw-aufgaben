package persistence;

public class CreateBankCommandListEntryProxi extends CreateBankCommandProxi implements PersistentCreateBankCommandListEntryProxi {

  long entryId;

  public CreateBankCommandListEntryProxi(long objectId, long entryId) {
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