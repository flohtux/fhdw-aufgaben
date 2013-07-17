package persistence;

public class MateriallistListEntryProxi extends MateriallistProxi implements PersistentMateriallistListEntryProxi {

  long entryId;

  public MateriallistListEntryProxi(long objectId, long entryId) {
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