package persistence;

public class AccountServiceSuccessfullStatesListEntryProxi extends AccountServiceSuccessfullStatesProxi implements PersistentAccountServiceSuccessfullStatesListEntryProxi {

  long entryId;

  public AccountServiceSuccessfullStatesListEntryProxi(long objectId, long entryId) {
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