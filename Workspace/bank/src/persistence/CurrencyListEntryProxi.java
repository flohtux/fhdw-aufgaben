package persistence;

public abstract class CurrencyListEntryProxi extends CurrencyProxi implements PersistentCurrencyListEntryProxi {

  long entryId;

  public CurrencyListEntryProxi(long objectId, long entryId) {
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