package persistence;

public class AccountGrantedDebitGrantListEntryProxi extends AccountGrantedDebitGrantProxi implements PersistentAccountGrantedDebitGrantListEntryProxi {

  long entryId;

  public AccountGrantedDebitGrantListEntryProxi(long objectId, long entryId) {
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