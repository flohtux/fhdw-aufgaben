package persistence;

public class ExchangeRateWrapperListEntryProxi extends ExchangeRateWrapperProxi implements PersistentExchangeRateWrapperListEntryProxi {

  long entryId;

  public ExchangeRateWrapperListEntryProxi(long objectId, long entryId) {
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