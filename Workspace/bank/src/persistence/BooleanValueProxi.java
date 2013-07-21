package persistence;



public abstract class BooleanValueProxi extends PersistentProxi implements PersistentBooleanValue{
    
    public BooleanValueProxi(long objectId) {
        super(objectId);
    }
    public BooleanValueProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentBooleanValue)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentBooleanValue)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentBooleanValue getThis() throws PersistenceException ;
    
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).deregister(observee);
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).register(observee);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBooleanValue)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
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

    
}
