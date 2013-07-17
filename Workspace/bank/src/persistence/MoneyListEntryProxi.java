package persistence;

public class MoneyListEntryProxi extends MoneyProxi implements PersistentMoneyListEntryProxi {

  long entryId;

  public MoneyListEntryProxi(long objectId, long entryId) {
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