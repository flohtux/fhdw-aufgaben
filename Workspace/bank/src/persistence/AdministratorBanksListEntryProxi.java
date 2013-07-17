package persistence;

public class AdministratorBanksListEntryProxi extends AdministratorBanksProxi implements PersistentAdministratorBanksListEntryProxi {

  long entryId;

  public AdministratorBanksListEntryProxi(long objectId, long entryId) {
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