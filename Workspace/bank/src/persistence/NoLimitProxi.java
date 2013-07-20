package persistence;

import model.UserException;

import model.visitor.*;

public class NoLimitProxi extends LimitTypeProxi implements PersistentNoLimit{
    
    public NoLimitProxi(long objectId) {
        super(objectId);
    }
    public NoLimitProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNoLimitFacade
            .getNoLimit(this.getId());
    }
    
    public long getClassId() {
        return 116;
    }
    
    public PersistentNoLimit getThis() throws PersistenceException {
        return ((PersistentNoLimit)this.getTheObject()).getThis();
    }
    
    public void accept(LimitTypeVisitor visitor) throws PersistenceException {
        visitor.handleNoLimit(this);
    }
    public <R> R accept(LimitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoLimit(this);
    }
    public <E extends UserException>  void accept(LimitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoLimit(this);
    }
    public <R, E extends UserException> R accept(LimitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoLimit(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNoLimit(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoLimit(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoLimit(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoLimit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoLimit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoLimit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoLimit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoLimit(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoLimit)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNoLimit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoLimit)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentNoLimit)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNoLimit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNoLimit)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNoLimit)this.getTheObject()).initializeOnInstantiation();
    }

    
}
