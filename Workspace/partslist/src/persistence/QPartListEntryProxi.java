package persistence;

public class QPartListEntryProxi extends QPartProxi implements PersistentQPartListEntryProxi {

  long entryId;

  public QPartListEntryProxi(long objectId, long entryId) {
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