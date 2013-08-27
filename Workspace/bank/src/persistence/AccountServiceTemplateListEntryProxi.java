package persistence;

public class AccountServiceTemplateListEntryProxi extends AccountServiceTemplateProxi implements PersistentAccountServiceTemplateListEntryProxi {

  long entryId;

  public AccountServiceTemplateListEntryProxi(long objectId, long entryId) {
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