package persistence;

import model.UserException;

import model.visitor.*;

public class DeclinedCompensationStateICProxi extends CompensationStateICProxi implements PersistentDeclinedCompensationState{
    
    public DeclinedCompensationStateICProxi(long objectId) {
        super(objectId);
    }
    public DeclinedCompensationStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDeclinedCompensationStateFacade
            .getDeclinedCompensationState(this.getId());
    }
    
    public long getClassId() {
        return 281;
    }
    
    public PersistentDeclinedCompensationState getThis() throws PersistenceException {
        return ((PersistentDeclinedCompensationState)this.getTheObject()).getThis();
    }
    
    public void accept(CompensationStateVisitor visitor) throws PersistenceException {
        visitor.handleDeclinedCompensationState(this);
    }
    public <R> R accept(CompensationStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeclinedCompensationState(this);
    }
    public <E extends UserException>  void accept(CompensationStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeclinedCompensationState(this);
    }
    public <R, E extends UserException> R accept(CompensationStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeclinedCompensationState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDeclinedCompensationState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeclinedCompensationState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeclinedCompensationState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeclinedCompensationState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDeclinedCompensationState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDeclinedCompensationState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDeclinedCompensationState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDeclinedCompensationState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDeclinedCompensationState)this.getTheObject()).deregister(observee);
    }
    public PersistentCompensation getCompensation() 
				throws PersistenceException{
        return ((PersistentDeclinedCompensationState)this.getTheObject()).getCompensation();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDeclinedCompensationState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDeclinedCompensationState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDeclinedCompensationState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDeclinedCompensationState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDeclinedCompensationState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDeclinedCompensationState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
