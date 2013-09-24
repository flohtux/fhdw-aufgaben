package persistence;

import model.UserException;

import model.visitor.*;

public class SuccessfulCompensationStateICProxi extends CompensationStateICProxi implements PersistentSuccessfulCompensationState{
    
    public SuccessfulCompensationStateICProxi(long objectId) {
        super(objectId);
    }
    public SuccessfulCompensationStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theSuccessfulCompensationStateFacade
            .getSuccessfulCompensationState(this.getId());
    }
    
    public long getClassId() {
        return 279;
    }
    
    public PersistentSuccessfulCompensationState getThis() throws PersistenceException {
        return ((PersistentSuccessfulCompensationState)this.getTheObject()).getThis();
    }
    
    public void accept(CompensationStateVisitor visitor) throws PersistenceException {
        visitor.handleSuccessfulCompensationState(this);
    }
    public <R> R accept(CompensationStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSuccessfulCompensationState(this);
    }
    public <E extends UserException>  void accept(CompensationStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSuccessfulCompensationState(this);
    }
    public <R, E extends UserException> R accept(CompensationStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSuccessfulCompensationState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleSuccessfulCompensationState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSuccessfulCompensationState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSuccessfulCompensationState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSuccessfulCompensationState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSuccessfulCompensationState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSuccessfulCompensationState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSuccessfulCompensationState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSuccessfulCompensationState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentSuccessfulCompensationState)this.getTheObject()).deregister(observee);
    }
    public PersistentCompensation getCompensation() 
				throws PersistenceException{
        return ((PersistentSuccessfulCompensationState)this.getTheObject()).getCompensation();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentSuccessfulCompensationState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentSuccessfulCompensationState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentSuccessfulCompensationState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentSuccessfulCompensationState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentSuccessfulCompensationState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentSuccessfulCompensationState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
