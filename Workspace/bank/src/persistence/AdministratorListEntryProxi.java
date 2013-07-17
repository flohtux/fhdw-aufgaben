package persistence;

public class AdministratorListEntryProxi extends AdministratorProxi implements PersistentAdministratorListEntryProxi {

  long entryId;

  public AdministratorListEntryProxi(long objectId, long entryId) {
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