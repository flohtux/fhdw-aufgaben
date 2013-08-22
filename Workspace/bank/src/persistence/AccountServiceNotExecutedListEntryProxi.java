package persistence;

public class AccountServiceNotExecutedListEntryProxi extends AccountServiceNotExecutedProxi implements PersistentAccountServiceNotExecutedListEntryProxi {

  long entryId;

  public AccountServiceNotExecutedListEntryProxi(long objectId, long entryId) {
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