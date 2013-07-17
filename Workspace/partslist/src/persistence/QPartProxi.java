package persistence;

import model.UserException;

import model.visitor.*;

public class QPartProxi extends PersistentProxi implements PersistentQPart{
    
    public QPartProxi(long objectId) {
        super(objectId);
    }
    public QPartProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theQPartFacade
            .getQPart(this.getId());
    }
    
    public long getClassId() {
        return 105;
    }
    
    public long getAmount() throws PersistenceException {
        return ((PersistentQPart)this.getTheObject()).getAmount();
    }
    public void setAmount(long newValue) throws PersistenceException {
        ((PersistentQPart)this.getTheObject()).setAmount(newValue);
    }
    public PersistentComponent getComponent() throws PersistenceException {
        return ((PersistentQPart)this.getTheObject()).getComponent();
    }
    public void setComponent(PersistentComponent newValue) throws PersistenceException , model.CycleException{
        ((PersistentQPart)this.getTheObject()).setComponent(newValue);
    }
    public PersistentQPart getThis() throws PersistenceException {
        return ((PersistentQPart)this.getTheObject()).getThis();
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleQPart(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQPart(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQPart(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQPart(this);
    }
    public void accept(ComponentHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleQPart(this);
    }
    public <R> R accept(ComponentHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQPart(this);
    }
    public <E extends UserException>  void accept(ComponentHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQPart(this);
    }
    public <R, E extends UserException> R accept(ComponentHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQPart(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleQPart(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQPart(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQPart(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQPart(this);
    }
    
    
    public boolean containsComponentHierarchy(final ComponentHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentQPart)this.getTheObject()).containsComponentHierarchy(part);
    }
    public PersistentProduct getMaster() 
				throws PersistenceException{
        return ((PersistentQPart)this.getTheObject()).getMaster();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentQPart)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyComponentHierarchy(final T parameter, final ComponentHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentQPart)this.getTheObject()).strategyComponentHierarchy(parameter, strategy);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentQPart)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentQPart)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentQPart)this.getTheObject()).handleResult(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentQPart)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentQPart)this.getTheObject()).initializeOnInstantiation();
    }

    
}
