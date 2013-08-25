package persistence;

public class DebitTransferListeListEntryProxi extends DebitTransferListeProxi implements PersistentDebitTransferListeListEntryProxi {

  long entryId;

  public DebitTransferListeListEntryProxi(long objectId, long entryId) {
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