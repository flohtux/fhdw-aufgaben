package persistence;

public class NoRequestStateListEntryProxi extends NoRequestStateProxi implements PersistentNoRequestStateListEntryProxi {

  long entryId;

  public NoRequestStateListEntryProxi(long objectId, long entryId) {
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