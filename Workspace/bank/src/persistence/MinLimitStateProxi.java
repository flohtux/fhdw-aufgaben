package persistence;

import model.UserException;

import model.visitor.*;

public class MinLimitStateProxi extends LimitStateProxi implements PersistentMinLimitState{
    
    public MinLimitStateProxi(long objectId) {
        super(objectId);
    }
    public MinLimitStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMinLimitStateFacade
            .getMinLimitState(this.getId());
    }
    
    public long getClassId() {
        return 143;
    }
    
    public PersistentMinLimitState getThis() throws PersistenceException {
        return ((PersistentMinLimitState)this.getTheObject()).getThis();
    }
    
    public void accept(LimitStateVisitor visitor) throws PersistenceException {
        visitor.handleMinLimitState(this);
    }
    public <R> R accept(LimitStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMinLimitState(this);
    }
    public <E extends UserException>  void accept(LimitStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMinLimitState(this);
    }
    public <R, E extends UserException> R accept(LimitStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMinLimitState(this);
    }
    public void accept(AccountLimitStateVisitor visitor) throws PersistenceException {
        visitor.handleMinLimitState(this);
    }
    public <R> R accept(AccountLimitStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMinLimitState(this);
    }
    public <E extends UserException>  void accept(AccountLimitStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMinLimitState(this);
    }
    public <R, E extends UserException> R accept(AccountLimitStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMinLimitState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleMinLimitState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMinLimitState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMinLimitState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMinLimitState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMinLimitState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMinLimitState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMinLimitState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMinLimitState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentMinLimitState)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMinLimitState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentMinLimitState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentMinLimitState)this.getTheObject()).updateObservers(event);
    }
    public void checkLimit(final PersistentMoney transactionValue) 
				throws PersistenceException{
        ((PersistentMinLimitState)this.getTheObject()).checkLimit(transactionValue);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMinLimitState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMinLimitState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMinLimitState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
