package persistence;

import model.UserException;

import model.visitor.*;

public class WaitingCompensationStateProxi extends CompensationStateProxi implements PersistentWaitingCompensationState{
    
    public WaitingCompensationStateProxi(long objectId) {
        super(objectId);
    }
    public WaitingCompensationStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theWaitingCompensationStateFacade
            .getWaitingCompensationState(this.getId());
    }
    
    public long getClassId() {
        return 278;
    }
    
    public PersistentWaitingCompensationState getThis() throws PersistenceException {
        return ((PersistentWaitingCompensationState)this.getTheObject()).getThis();
    }
    
    public void accept(CompensationStateVisitor visitor) throws PersistenceException {
        visitor.handleWaitingCompensationState(this);
    }
    public <R> R accept(CompensationStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWaitingCompensationState(this);
    }
    public <E extends UserException>  void accept(CompensationStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWaitingCompensationState(this);
    }
    public <R, E extends UserException> R accept(CompensationStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWaitingCompensationState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleWaitingCompensationState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWaitingCompensationState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWaitingCompensationState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWaitingCompensationState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleWaitingCompensationState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWaitingCompensationState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWaitingCompensationState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWaitingCompensationState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentWaitingCompensationState)this.getTheObject()).deregister(observee);
    }
    public PersistentCompensation getCompensation() 
				throws PersistenceException{
        return ((PersistentWaitingCompensationState)this.getTheObject()).getCompensation();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentWaitingCompensationState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentWaitingCompensationState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentWaitingCompensationState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentWaitingCompensationState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentWaitingCompensationState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentWaitingCompensationState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
