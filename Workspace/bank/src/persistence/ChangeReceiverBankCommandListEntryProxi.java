package persistence;

public class ChangeReceiverBankCommandListEntryProxi extends ChangeReceiverBankCommandProxi implements PersistentChangeReceiverBankCommandListEntryProxi {

  long entryId;

  public ChangeReceiverBankCommandListEntryProxi(long objectId, long entryId) {
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