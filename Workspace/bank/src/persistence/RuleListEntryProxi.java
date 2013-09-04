package persistence;

public abstract class RuleListEntryProxi extends RuleProxi implements PersistentRuleListEntryProxi {

  long entryId;

  public RuleListEntryProxi(long objectId, long entryId) {
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