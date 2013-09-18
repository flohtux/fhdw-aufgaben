package persistence;

import model.UserException;

import model.visitor.*;

public class AcceptedStateProxi extends CompensationRequestStateProxi implements PersistentAcceptedState{
    
    public AcceptedStateProxi(long objectId) {
        super(objectId);
    }
    public AcceptedStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAcceptedStateFacade
            .getAcceptedState(this.getId());
    }
    
    public long getClassId() {
        return 265;
    }
    
    public PersistentAcceptedState getThis() throws PersistenceException {
        return ((PersistentAcceptedState)this.getTheObject()).getThis();
    }
    
    public void accept(CompensationRequestStateVisitor visitor) throws PersistenceException {
        visitor.handleAcceptedState(this);
    }
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAcceptedState(this);
    }
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAcceptedState(this);
    }
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAcceptedState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAcceptedState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAcceptedState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAcceptedState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAcceptedState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAcceptedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAcceptedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAcceptedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAcceptedState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAcceptedState)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAcceptedState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAcceptedState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAcceptedState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAcceptedState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAcceptedState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAcceptedState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
