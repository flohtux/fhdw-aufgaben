package persistence;



public abstract class StornoStateProxi extends PersistentProxi implements PersistentStornoState{
    
    public StornoStateProxi(long objectId) {
        super(objectId);
    }
    public StornoStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentStornoState)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentStornoState)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentStornoState getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).deregister(observee);
    }
    public PersistentCompensation getDebitTransfer() 
				throws PersistenceException{
        return ((PersistentStornoState)this.getTheObject()).getDebitTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentStornoState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
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
