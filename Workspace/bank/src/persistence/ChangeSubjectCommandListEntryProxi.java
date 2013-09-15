package persistence;

public class ChangeSubjectCommandListEntryProxi extends ChangeSubjectCommandProxi implements PersistentChangeSubjectCommandListEntryProxi {

  long entryId;

  public ChangeSubjectCommandListEntryProxi(long objectId, long entryId) {
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