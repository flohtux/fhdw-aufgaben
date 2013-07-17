package persistence;

import model.UserException;

import model.visitor.*;

public class NoLimitStateICProxi extends AccountLimitStateICProxi implements PersistentNoLimitState{
    
    public NoLimitStateICProxi(long objectId) {
        super(objectId);
    }
    public NoLimitStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNoLimitStateFacade
            .getNoLimitState(this.getId());
    }
    
    public long getClassId() {
        return 140;
    }
    
    public PersistentNoLimitState getThis() throws PersistenceException {
        return ((PersistentNoLimitState)this.getTheObject()).getThis();
    }
    
    public void accept(AccountLimitStateVisitor visitor) throws PersistenceException {
        visitor.handleNoLimitState(this);
    }
    public <R> R accept(AccountLimitStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoLimitState(this);
    }
    public <E extends UserException>  void accept(AccountLimitStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoLimitState(this);
    }
    public <R, E extends UserException> R accept(AccountLimitStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoLimitState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNoLimitState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoLimitState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoLimitState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoLimitState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoLimitState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoLimitState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoLimitState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoLimitState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoLimitState)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNoLimitState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoLimitState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentNoLimitState)this.getTheObject()).updateObservers(event);
    }
    public void checkLimit(final PersistentMoney transactionValue) 
				throws PersistenceException{
        ((PersistentNoLimitState)this.getTheObject()).checkLimit(transactionValue);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNoLimitState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNoLimitState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNoLimitState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
