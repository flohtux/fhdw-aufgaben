package persistence;

public class SubjectRuleListEntryProxi extends SubjectRuleProxi implements PersistentSubjectRuleListEntryProxi {

  long entryId;

  public SubjectRuleListEntryProxi(long objectId, long entryId) {
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