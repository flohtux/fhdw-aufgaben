package persistence;



public abstract class DebitNoteTransferTransactionICProxi extends PersistentInCacheProxiOptimistic implements PersistentDebitNoteTransferTransaction{
    
    public DebitNoteTransferTransactionICProxi(long objectId) {
        super(objectId);
    }
    public DebitNoteTransferTransactionICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitNoteTransferTransaction)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentDebitNoteTransferTransaction getThis() throws PersistenceException ;
    
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).deregister(observee);
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).register(observee);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).execute();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).initializeOnInstantiation();
    }

    
}
