package persistence;

public class MoneyRuleListEntryProxi extends MoneyRuleProxi implements PersistentMoneyRuleListEntryProxi {

  long entryId;

  public MoneyRuleListEntryProxi(long objectId, long entryId) {
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