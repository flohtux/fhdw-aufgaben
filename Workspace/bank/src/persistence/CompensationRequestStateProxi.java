package persistence;

import model.UserException;

import model.visitor.*;

public class CompensationRequestStateProxi extends PersistentProxi implements PersistentCompensationRequestState{
    
    public CompensationRequestStateProxi(long objectId) {
        super(objectId);
    }
    public CompensationRequestStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompensationRequestStateFacade
            .getCompensationRequestState(this.getId());
    }
    
    public long getClassId() {
        return 264;
    }
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentCompensationRequestState)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentCompensationRequestState)this.getTheObject()).setSubService(newValue);
    }
    public PersistentCompensationRequestState getThis() throws PersistenceException {
        return ((PersistentCompensationRequestState)this.getTheObject()).getThis();
    }
    
    public void accept(CompensationRequestStateVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequestState(this);
    }
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequestState(this);
    }
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequestState(this);
    }
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequestState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequestState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequestState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequestState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequestState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequestState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequestState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequestState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequestState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationRequestState)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompensationRequestState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationRequestState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCompensationRequestState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompensationRequestState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompensationRequestState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompensationRequestState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
