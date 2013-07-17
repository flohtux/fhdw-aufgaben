package persistence;

public class AmountListEntryProxi extends AmountProxi implements PersistentAmountListEntryProxi {

  long entryId;

  public AmountListEntryProxi(long objectId, long entryId) {
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