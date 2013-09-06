package persistence;



public abstract class TriggerStateICProxi extends PersistentInCacheProxiOptimistic implements PersistentTriggerState{
    
    public TriggerStateICProxi(long objectId) {
        super(objectId);
    }
    public TriggerStateICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentTriggerState)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentTriggerState)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentTriggerState getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTriggerState)this.getTheObject()).deregister(observee);
    }
    public PersistentTrigger getMaster() 
				throws PersistenceException{
        return ((PersistentTriggerState)this.getTheObject()).getMaster();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTriggerState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTriggerState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTriggerState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTriggerState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTriggerState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTriggerState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
