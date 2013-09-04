package persistence;

public class AccountTriggerListeListEntryProxi extends AccountTriggerListeProxi implements PersistentAccountTriggerListeListEntryProxi {

  long entryId;

  public AccountTriggerListeListEntryProxi(long objectId, long entryId) {
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