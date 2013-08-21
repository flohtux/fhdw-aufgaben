package persistence;



public abstract class DebitTransferStateProxi extends PersistentProxi implements PersistentDebitTransferState{
    
    public DebitTransferStateProxi(long objectId) {
        super(objectId);
    }
    public DebitTransferStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitTransferState)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitTransferState)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentDebitTransferState getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitTransfer getDebitTransfer() 
				throws PersistenceException{
        return ((PersistentDebitTransferState)this.getTheObject()).getDebitTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentBooleanValue isExecutable() 
				throws PersistenceException{
        return ((PersistentDebitTransferState)this.getTheObject()).isExecutable();
    }

    
}
