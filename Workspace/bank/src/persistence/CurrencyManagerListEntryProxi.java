package persistence;

public class CurrencyManagerListEntryProxi extends CurrencyManagerProxi implements PersistentCurrencyManagerListEntryProxi {

  long entryId;

  public CurrencyManagerListEntryProxi(long objectId, long entryId) {
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