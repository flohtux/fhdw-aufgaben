package persistence;

public class ChangeReceiverAccountCommandListEntryProxi extends ChangeReceiverAccountCommandProxi implements PersistentChangeReceiverAccountCommandListEntryProxi {

  long entryId;

  public ChangeReceiverAccountCommandListEntryProxi(long objectId, long entryId) {
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