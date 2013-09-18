package persistence;

import model.UserException;

import model.visitor.*;

public class WaitingStateProxi extends CompensationRequestStateProxi implements PersistentWaitingState{
    
    public WaitingStateProxi(long objectId) {
        super(objectId);
    }
    public WaitingStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theWaitingStateFacade
            .getWaitingState(this.getId());
    }
    
    public long getClassId() {
        return 263;
    }
    
    public PersistentWaitingState getThis() throws PersistenceException {
        return ((PersistentWaitingState)this.getTheObject()).getThis();
    }
    
    public void accept(CompensationRequestStateVisitor visitor) throws PersistenceException {
        visitor.handleWaitingState(this);
    }
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWaitingState(this);
    }
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWaitingState(this);
    }
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWaitingState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleWaitingState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWaitingState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWaitingState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWaitingState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleWaitingState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWaitingState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWaitingState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWaitingState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentWaitingState)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentWaitingState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentWaitingState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentWaitingState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentWaitingState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentWaitingState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentWaitingState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
