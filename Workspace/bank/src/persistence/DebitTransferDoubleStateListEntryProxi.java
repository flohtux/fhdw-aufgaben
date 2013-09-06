package persistence;

public class DebitTransferDoubleStateListEntryProxi extends DebitTransferDoubleStateProxi implements PersistentDebitTransferDoubleStateListEntryProxi {

  long entryId;

  public DebitTransferDoubleStateListEntryProxi(long objectId, long entryId) {
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