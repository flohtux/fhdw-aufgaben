package persistence;



public abstract class DebitNoteTransferStateProxi extends PersistentProxi implements PersistentDebitNoteTransferState{
    
    public DebitNoteTransferStateProxi(long objectId) {
        super(objectId);
    }
    public DebitNoteTransferStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitNoteTransferState)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitNoteTransferState)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentDebitNoteTransferState getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitNoteTransfer getDebitNoteTransfer() 
				throws PersistenceException{
        return ((PersistentDebitNoteTransferState)this.getTheObject()).getDebitNoteTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
