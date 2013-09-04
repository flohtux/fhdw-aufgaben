package persistence;

public class IncomingAccountRuleListEntryProxi extends IncomingAccountRuleProxi implements PersistentIncomingAccountRuleListEntryProxi {

  long entryId;

  public IncomingAccountRuleListEntryProxi(long objectId, long entryId) {
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