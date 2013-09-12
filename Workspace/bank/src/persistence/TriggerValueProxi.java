package persistence;



public abstract class TriggerValueProxi extends PersistentProxi implements PersistentTriggerValue{
    
    public TriggerValueProxi(long objectId) {
        super(objectId);
    }
    public TriggerValueProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentTriggerValue)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentTriggerValue)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentTriggerValue getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTriggerValue)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTriggerValue)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTriggerValue)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTriggerValue)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTriggerValue)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentTriggerValue copy() 
				throws PersistenceException{
        return ((PersistentTriggerValue)this.getTheObject()).copy();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTriggerValue)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTriggerValue)this.getTheObject()).initializeOnInstantiation();
    }

    
}
