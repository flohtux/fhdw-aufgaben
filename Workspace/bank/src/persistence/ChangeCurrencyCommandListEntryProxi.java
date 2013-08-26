package persistence;

public class ChangeCurrencyCommandListEntryProxi extends ChangeCurrencyCommandProxi implements PersistentChangeCurrencyCommandListEntryProxi {

  long entryId;

  public ChangeCurrencyCommandListEntryProxi(long objectId, long entryId) {
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