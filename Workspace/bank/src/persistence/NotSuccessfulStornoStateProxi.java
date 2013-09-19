package persistence;

import model.UserException;

import model.visitor.*;

public class NotSuccessfulStornoStateProxi extends StornoStateProxi implements PersistentNotSuccessfulStornoState{
    
    public NotSuccessfulStornoStateProxi(long objectId) {
        super(objectId);
    }
    public NotSuccessfulStornoStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNotSuccessfulStornoStateFacade
            .getNotSuccessfulStornoState(this.getId());
    }
    
    public long getClassId() {
        return 134;
    }
    
    public PersistentNotSuccessfulStornoState getThis() throws PersistenceException {
        return ((PersistentNotSuccessfulStornoState)this.getTheObject()).getThis();
    }
    
    public void accept(StornoStateVisitor visitor) throws PersistenceException {
        visitor.handleNotSuccessfulStornoState(this);
    }
    public <R> R accept(StornoStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotSuccessfulStornoState(this);
    }
    public <E extends UserException>  void accept(StornoStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotSuccessfulStornoState(this);
    }
    public <R, E extends UserException> R accept(StornoStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotSuccessfulStornoState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNotSuccessfulStornoState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotSuccessfulStornoState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotSuccessfulStornoState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotSuccessfulStornoState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNotSuccessfulStornoState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotSuccessfulStornoState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotSuccessfulStornoState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotSuccessfulStornoState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNotSuccessfulStornoState)this.getTheObject()).deregister(observee);
    }
    public PersistentCompensation getDebitTransfer() 
				throws PersistenceException{
        return ((PersistentNotSuccessfulStornoState)this.getTheObject()).getDebitTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNotSuccessfulStornoState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNotSuccessfulStornoState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentNotSuccessfulStornoState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNotSuccessfulStornoState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNotSuccessfulStornoState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNotSuccessfulStornoState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
