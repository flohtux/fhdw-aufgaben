package persistence;



public abstract class StateICProxi extends PersistentInCacheProxiOptimistic implements PersistentState{
    
    public StateICProxi(long objectId) {
        super(objectId);
    }
    public StateICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public abstract PersistentState getThis() throws PersistenceException ;
    
    
    
    public PersistentComponent getMaster() 
				throws PersistenceException{
        return ((PersistentState)this.getTheObject()).getMaster();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMateriallist fetchMateriallist() 
				throws PersistenceException{
        return ((PersistentState)this.getTheObject()).fetchMateriallist();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentState)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentState)this.getTheObject()).handleResult(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
