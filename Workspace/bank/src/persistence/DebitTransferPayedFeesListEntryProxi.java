package persistence;

public class DebitTransferPayedFeesListEntryProxi extends DebitTransferPayedFeesProxi implements PersistentDebitTransferPayedFeesListEntryProxi {

  long entryId;

  public DebitTransferPayedFeesListEntryProxi(long objectId, long entryId) {
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