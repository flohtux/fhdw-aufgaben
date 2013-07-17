package persistence;

import model.UserException;

import model.visitor.*;

public class MaxLimitStateProxi extends LimitStateProxi implements PersistentMaxLimitState{
    
    public MaxLimitStateProxi(long objectId) {
        super(objectId);
    }
    public MaxLimitStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMaxLimitStateFacade
            .getMaxLimitState(this.getId());
    }
    
    public long getClassId() {
        return 145;
    }
    
    public PersistentMaxLimitState getThis() throws PersistenceException {
        return ((PersistentMaxLimitState)this.getTheObject()).getThis();
    }
    
    public void accept(LimitStateVisitor visitor) throws PersistenceException {
        visitor.handleMaxLimitState(this);
    }
    public <R> R accept(LimitStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMaxLimitState(this);
    }
    public <E extends UserException>  void accept(LimitStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMaxLimitState(this);
    }
    public <R, E extends UserException> R accept(LimitStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMaxLimitState(this);
    }
    public void accept(AccountLimitStateVisitor visitor) throws PersistenceException {
        visitor.handleMaxLimitState(this);
    }
    public <R> R accept(AccountLimitStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMaxLimitState(this);
    }
    public <E extends UserException>  void accept(AccountLimitStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMaxLimitState(this);
    }
    public <R, E extends UserException> R accept(AccountLimitStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMaxLimitState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleMaxLimitState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMaxLimitState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMaxLimitState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMaxLimitState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMaxLimitState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMaxLimitState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMaxLimitState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMaxLimitState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentMaxLimitState)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMaxLimitState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentMaxLimitState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentMaxLimitState)this.getTheObject()).updateObservers(event);
    }
    public void checkLimit(final PersistentMoney transactionValue) 
				throws PersistenceException{
        ((PersistentMaxLimitState)this.getTheObject()).checkLimit(transactionValue);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMaxLimitState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMaxLimitState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMaxLimitState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
