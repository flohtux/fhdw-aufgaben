package persistence;

public class MaterialListEntryProxi extends MaterialProxi implements PersistentMaterialListEntryProxi {

  long entryId;

  public MaterialListEntryProxi(long objectId, long entryId) {
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