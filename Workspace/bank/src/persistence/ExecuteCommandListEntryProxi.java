package persistence;

public class ExecuteCommandListEntryProxi extends ExecuteCommandProxi implements PersistentExecuteCommandListEntryProxi {

  long entryId;

  public ExecuteCommandListEntryProxi(long objectId, long entryId) {
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