package persistence;

public class YenListEntryProxi extends YenProxi implements PersistentYenListEntryProxi {

  long entryId;

  public YenListEntryProxi(long objectId, long entryId) {
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