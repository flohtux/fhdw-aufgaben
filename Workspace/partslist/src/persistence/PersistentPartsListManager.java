package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentPartsListManager extends Invoker, Anything, AbstractPersistentProxi {
    
    public PersistentPartsListManager getThis() throws PersistenceException ;
    
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void addComponent(final PersistentProduct product, final PersistentComponent newPart, final long amount, final Invoker invoker) 
				throws PersistenceException;
    public void createComponent(final String name, final String componentType, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addComponent(final PersistentProduct product, final PersistentComponent newPart, final long amount) 
				throws model.CycleException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public long count(final PersistentComponent component) 
				throws PersistenceException;
    public PersistentComponent createComponent(final String name, final String componentType) 
				throws model.DoubleDefinitionException, PersistenceException;
    public PersistentMateriallist fetchMateriallist(final PersistentComponent component) 
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

