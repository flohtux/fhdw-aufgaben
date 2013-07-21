package persistence;



public abstract class DebitNoteTransferStateICProxi extends PersistentInCacheProxiOptimistic implements PersistentDebitNoteTransferState{
    
    public DebitNoteTransferStateICProxi(long objectId) {
        super(objectId);
    }
    public DebitNoteTransferStateICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public PersistentDebitNoteTransferState getState() throws PersistenceException {
        return ((PersistentDebitNoteTransferState)this.getTheObject()).getState();
    }
    public void setState(PersistentDebitNoteTransferState newValue) throws PersistenceException {
        ((PersistentDebitNoteTransferState)this.getTheObject()).setState(newValue);
    }
    public PersistentStornoState getStornoState() throws PersistenceException {
        return ((PersistentDebitNoteTransferState)this.getTheObject()).getStornoState();
    }
    public void setStornoState(PersistentStornoState newValue) throws PersistenceException {
        ((PersistentDebitNoteTransferState)this.getTheObject()).setStornoState(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitNoteTransferState)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitNoteTransferState)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentDebitNoteTransferState getThis() throws PersistenceException ;
    
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitNoteTransferState getDebitNoteTransfer() 
				throws PersistenceException{
        return ((PersistentDebitNoteTransferState)this.getTheObject()).getDebitNoteTransfer();
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).register(observee);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
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
