package persistence;

public class ExecuteCompensationCommandListEntryProxi extends ExecuteCompensationCommandProxi implements PersistentExecuteCompensationCommandListEntryProxi {

  long entryId;

  public ExecuteCompensationCommandListEntryProxi(long objectId, long entryId) {
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