package persistence;



public abstract class BooleanValueICProxi extends PersistentInCacheProxiOptimistic implements PersistentBooleanValue{
    
    public BooleanValueICProxi(long objectId) {
        super(objectId);
    }
    public BooleanValueICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentBooleanValue)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentBooleanValue)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentBooleanValue getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).initializeOnInstantiation();
    }
    public boolean isTrue() 
				throws PersistenceException{
        return ((PersistentBooleanValue)this.getTheObject()).isTrue();
    }
    public PersistentBooleanValue or(final PersistentBooleanValue value) 
				throws PersistenceException{
        return ((PersistentBooleanValue)this.getTheObject()).or(value);
    }

    
}
