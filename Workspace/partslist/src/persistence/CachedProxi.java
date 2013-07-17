package persistence;

import model.UserException;

import model.visitor.*;

public class CachedProxi extends StateProxi implements PersistentCached{
    
    public CachedProxi(long objectId) {
        super(objectId);
    }
    public CachedProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCachedFacade
            .getCached(this.getId());
    }
    
    public long getClassId() {
        return 107;
    }
    
    public PersistentMateriallist getCachedList() throws PersistenceException {
        return ((PersistentCached)this.getTheObject()).getCachedList();
    }
    public void setCachedList(PersistentMateriallist newValue) throws PersistenceException {
        ((PersistentCached)this.getTheObject()).setCachedList(newValue);
    }
    public PersistentCached getThis() throws PersistenceException {
        return ((PersistentCached)this.getTheObject()).getThis();
    }
    
    public void accept(StateVisitor visitor) throws PersistenceException {
        visitor.handleCached(this);
    }
    public <R> R accept(StateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCached(this);
    }
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCached(this);
    }
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCached(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleCached(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCached(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCached(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCached(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCached(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCached(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCached(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCached(this);
    }
    
    
    public PersistentComponent getMaster() 
				throws PersistenceException{
        return ((PersistentCached)this.getTheObject()).getMaster();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCached)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCached)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMateriallist fetchMateriallist() 
				throws PersistenceException{
        return ((PersistentCached)this.getTheObject()).fetchMateriallist();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCached)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentCached)this.getTheObject()).handleResult(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCached)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCached)this.getTheObject()).initializeOnInstantiation();
    }

    
}
