package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentComponent extends Invoker, ComponentHierarchyHIERARCHY, Anything, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public PersistentState getCurrentState() throws PersistenceException ;
    public void setCurrentState(PersistentState newValue) throws PersistenceException ;
    public abstract PersistentComponent getThis() throws PersistenceException ;
    
    public void accept(ComponentVisitor visitor) throws PersistenceException;
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public QPartSearchList getPartOf() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentMateriallist createMateriallist() 
				throws PersistenceException;
    public PersistentMateriallist fetchMateriallist() 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

