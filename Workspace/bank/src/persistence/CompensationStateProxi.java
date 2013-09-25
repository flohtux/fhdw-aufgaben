package persistence;



public abstract class CompensationStateProxi extends PersistentProxi implements PersistentCompensationState{
    
    public CompensationStateProxi(long objectId) {
        super(objectId);
    }
    public CompensationStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentCompensationState)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentCompensationState)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentCompensationState getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationState)this.getTheObject()).deregister(observee);
    }
    public PersistentCompensation getCompensation() 
				throws PersistenceException{
        return ((PersistentCompensationState)this.getTheObject()).getCompensation();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompensationState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCompensationState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompensationState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompensationState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompensationState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
