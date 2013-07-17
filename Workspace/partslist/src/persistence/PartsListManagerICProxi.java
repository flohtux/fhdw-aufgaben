package persistence;

import model.UserException;

import model.visitor.*;

public class PartsListManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentPartsListManager{
    
    public PartsListManagerICProxi(long objectId) {
        super(objectId);
    }
    public PartsListManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade
            .getPartsListManager(this.getId());
    }
    
    public long getClassId() {
        return 103;
    }
    
    public PersistentPartsListManager getThis() throws PersistenceException {
        return ((PersistentPartsListManager)this.getTheObject()).getThis();
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handlePartsListManager(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePartsListManager(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePartsListManager(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePartsListManager(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePartsListManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePartsListManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePartsListManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePartsListManager(this);
    }
    
    
    public void addComponent(final PersistentProduct product, final PersistentComponent newPart, final long amount, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).addComponent(product, newPart, amount, invoker);
    }
    public void createComponent(final String name, final String componentType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).createComponent(name, componentType, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addComponent(final PersistentProduct product, final PersistentComponent newPart, final long amount) 
				throws model.CycleException, PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).addComponent(product, newPart, amount);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public long count(final PersistentComponent component) 
				throws PersistenceException{
        return ((PersistentPartsListManager)this.getTheObject()).count(component);
    }
    public PersistentComponent createComponent(final String name, final String componentType) 
				throws model.DoubleDefinitionException, PersistenceException{
        return ((PersistentPartsListManager)this.getTheObject()).createComponent(name, componentType);
    }
    public PersistentMateriallist fetchMateriallist(final PersistentComponent component) 
				throws PersistenceException{
        return ((PersistentPartsListManager)this.getTheObject()).fetchMateriallist(component);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).handleResult(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).initializeOnInstantiation();
    }

    
}
