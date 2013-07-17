package persistence;

import model.UserException;

import model.visitor.*;

public class NotCachedICProxi extends StateICProxi implements PersistentNotCached{
    
    public NotCachedICProxi(long objectId) {
        super(objectId);
    }
    public NotCachedICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNotCachedFacade
            .getNotCached(this.getId());
    }
    
    public long getClassId() {
        return 113;
    }
    
    public PersistentNotCached getThis() throws PersistenceException {
        return ((PersistentNotCached)this.getTheObject()).getThis();
    }
    
    public void accept(StateVisitor visitor) throws PersistenceException {
        visitor.handleNotCached(this);
    }
    public <R> R accept(StateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotCached(this);
    }
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotCached(this);
    }
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotCached(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleNotCached(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotCached(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotCached(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotCached(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNotCached(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotCached(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotCached(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotCached(this);
    }
    
    
    public PersistentComponent getMaster() 
				throws PersistenceException{
        return ((PersistentNotCached)this.getTheObject()).getMaster();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNotCached)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNotCached)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMateriallist fetchMateriallist() 
				throws PersistenceException{
        return ((PersistentNotCached)this.getTheObject()).fetchMateriallist();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentNotCached)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentNotCached)this.getTheObject()).handleResult(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNotCached)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNotCached)this.getTheObject()).initializeOnInstantiation();
    }

    
}
