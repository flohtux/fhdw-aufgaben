package persistence;

public class DebitTransferTemplateListEntryProxi extends DebitTransferTemplateProxi implements PersistentDebitTransferTemplateListEntryProxi {

  long entryId;

  public DebitTransferTemplateListEntryProxi(long objectId, long entryId) {
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