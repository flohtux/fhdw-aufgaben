package persistence;

public class AccountMoney2ListEntryProxi extends AccountMoney2Proxi implements PersistentAccountMoney2ListEntryProxi {

  long entryId;

  public AccountMoney2ListEntryProxi(long objectId, long entryId) {
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