package persistence;

public class TemplateStateListEntryProxi extends TemplateStateProxi implements PersistentTemplateStateListEntryProxi {

  long entryId;

  public TemplateStateListEntryProxi(long objectId, long entryId) {
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