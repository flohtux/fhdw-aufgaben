package persistence;

public class AdministratorCurrencyManagerListEntryProxi extends AdministratorCurrencyManagerProxi implements PersistentAdministratorCurrencyManagerListEntryProxi {

  long entryId;

  public AdministratorCurrencyManagerListEntryProxi(long objectId, long entryId) {
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