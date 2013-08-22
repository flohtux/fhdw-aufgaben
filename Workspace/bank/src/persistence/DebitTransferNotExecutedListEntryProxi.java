package persistence;

public class DebitTransferNotExecutedListEntryProxi extends DebitTransferNotExecutedProxi implements PersistentDebitTransferNotExecutedListEntryProxi {

  long entryId;

  public DebitTransferNotExecutedListEntryProxi(long objectId, long entryId) {
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