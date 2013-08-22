package persistence;

public class DebitTransferSuccessfulListEntryProxi extends DebitTransferSuccessfulProxi implements PersistentDebitTransferSuccessfulListEntryProxi {

  long entryId;

  public DebitTransferSuccessfulListEntryProxi(long objectId, long entryId) {
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