package persistence;



public abstract class StornoStateICProxi extends PersistentInCacheProxiOptimistic implements PersistentStornoState{
    
    public StornoStateICProxi(long objectId) {
        super(objectId);
    }
    public StornoStateICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentStornoState)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentStornoState)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentStornoState getThis() throws PersistenceException ;
    
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitNoteTransferState getDebitNoteTransfer() 
				throws PersistenceException{
        return ((PersistentStornoState)this.getTheObject()).getDebitNoteTransfer();
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).register(observee);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
