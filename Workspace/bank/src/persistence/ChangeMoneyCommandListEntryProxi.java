package persistence;

public class ChangeMoneyCommandListEntryProxi extends ChangeMoneyCommandProxi implements PersistentChangeMoneyCommandListEntryProxi {

  long entryId;

  public ChangeMoneyCommandListEntryProxi(long objectId, long entryId) {
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