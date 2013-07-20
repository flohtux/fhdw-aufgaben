package persistence;

public class NotSuccessfullStorneStateListEntryProxi extends NotSuccessfullStorneStateProxi implements PersistentNotSuccessfullStorneStateListEntryProxi {

  long entryId;

  public NotSuccessfullStorneStateListEntryProxi(long objectId, long entryId) {
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