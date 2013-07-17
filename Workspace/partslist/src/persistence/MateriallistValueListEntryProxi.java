package persistence;

public class MateriallistValueListEntryProxi extends MateriallistValueProxi implements PersistentMateriallistValueListEntryProxi {

  long entryId;

  public MateriallistValueListEntryProxi(long objectId, long entryId) {
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