package persistence;

public class AccountAllCompensationListEntryProxi extends AccountAllCompensationProxi implements PersistentAccountAllCompensationListEntryProxi {

  long entryId;

  public AccountAllCompensationListEntryProxi(long objectId, long entryId) {
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