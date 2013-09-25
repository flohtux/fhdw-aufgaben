package persistence;



public abstract class DebitTransferStateICProxi extends PersistentInCacheProxiOptimistic implements PersistentDebitTransferState{
    
    public DebitTransferStateICProxi(long objectId) {
        super(objectId);
    }
    public DebitTransferStateICProxi(PersistentObject object) {
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
    public PersistentDebitTransferTransaction getDebitTransfer() 
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
    public void addDebitTransferFromList(final PersistentDebitTransferState state) 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).addDebitTransferFromList(state);
    }
    public void changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).changeState(newState);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentDebitTransferState copy() 
				throws PersistenceException{
        return ((PersistentDebitTransferState)this.getTheObject()).copy();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentBooleanValue isCompensated() 
				throws PersistenceException{
        return ((PersistentDebitTransferState)this.getTheObject()).isCompensated();
    }
    public PersistentBooleanValue isExecutable() 
				throws PersistenceException{
        return ((PersistentDebitTransferState)this.getTheObject()).isExecutable();
    }
    public PersistentBooleanValue isTransaction() 
				throws PersistenceException{
        return ((PersistentDebitTransferState)this.getTheObject()).isTransaction();
    }
    public void removeDebitTransferFromList() 
				throws PersistenceException{
        ((PersistentDebitTransferState)this.getTheObject()).removeDebitTransferFromList();
    }

    
}
