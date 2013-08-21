package persistence;

public class AccountServiceNotSuccessfullStatesListEntryProxi extends AccountServiceNotSuccessfullStatesProxi implements PersistentAccountServiceNotSuccessfullStatesListEntryProxi {

  long entryId;

  public AccountServiceNotSuccessfullStatesListEntryProxi(long objectId, long entryId) {
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