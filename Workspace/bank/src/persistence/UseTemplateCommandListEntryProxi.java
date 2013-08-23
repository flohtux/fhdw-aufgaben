package persistence;

public class UseTemplateCommandListEntryProxi extends UseTemplateCommandProxi implements PersistentUseTemplateCommandListEntryProxi {

  long entryId;

  public UseTemplateCommandListEntryProxi(long objectId, long entryId) {
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