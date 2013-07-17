package persistence;



public abstract class ComponentProxi extends PersistentProxi implements PersistentComponent{
    
    public ComponentProxi(long objectId) {
        super(objectId);
    }
    public ComponentProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentComponent)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentComponent)this.getTheObject()).setName(newValue);
    }
    public PersistentState getCurrentState() throws PersistenceException {
        return ((PersistentComponent)this.getTheObject()).getCurrentState();
    }
    public void setCurrentState(PersistentState newValue) throws PersistenceException {
        ((PersistentComponent)this.getTheObject()).setCurrentState(newValue);
    }
    public abstract PersistentComponent getThis() throws PersistenceException ;
    
    
    
    public QPartSearchList getPartOf() 
				throws PersistenceException{
        return ((PersistentComponent)this.getTheObject()).getPartOf();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentComponent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public boolean containsComponentHierarchy(final ComponentHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentComponent)this.getTheObject()).containsComponentHierarchy(part);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentComponent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMateriallist createMateriallist() 
				throws PersistenceException{
        return ((PersistentComponent)this.getTheObject()).createMateriallist();
    }
    public PersistentMateriallist fetchMateriallist() 
				throws PersistenceException{
        return ((PersistentComponent)this.getTheObject()).fetchMateriallist();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentComponent)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentComponent)this.getTheObject()).handleResult(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentComponent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentComponent)this.getTheObject()).initializeOnInstantiation();
    }
    public <T> T strategyComponentHierarchy(final T parameter, final ComponentHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentComponent)this.getTheObject()).strategyComponentHierarchy(parameter, strategy);
    }

    
}
