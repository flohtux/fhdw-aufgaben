package persistence;

public abstract class ComponentListEntryProxi extends ComponentProxi implements PersistentComponentListEntryProxi {

  long entryId;

  public ComponentListEntryProxi(long objectId, long entryId) {
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