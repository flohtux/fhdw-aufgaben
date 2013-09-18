package persistence;

import model.UserException;

import model.visitor.*;

public class DeclinedStateProxi extends CompensationRequestStateProxi implements PersistentDeclinedState{
    
    public DeclinedStateProxi(long objectId) {
        super(objectId);
    }
    public DeclinedStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDeclinedStateFacade
            .getDeclinedState(this.getId());
    }
    
    public long getClassId() {
        return 266;
    }
    
    public PersistentDeclinedState getThis() throws PersistenceException {
        return ((PersistentDeclinedState)this.getTheObject()).getThis();
    }
    
    public void accept(CompensationRequestStateVisitor visitor) throws PersistenceException {
        visitor.handleDeclinedState(this);
    }
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeclinedState(this);
    }
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeclinedState(this);
    }
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeclinedState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDeclinedState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeclinedState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeclinedState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeclinedState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDeclinedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeclinedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeclinedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeclinedState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDeclinedState)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDeclinedState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDeclinedState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDeclinedState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDeclinedState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDeclinedState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDeclinedState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
