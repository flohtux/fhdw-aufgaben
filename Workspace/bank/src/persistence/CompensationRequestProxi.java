package persistence;

import model.UserException;

import model.visitor.*;

public class CompensationRequestProxi extends PersistentProxi implements PersistentCompensationRequest{
    
    public CompensationRequestProxi(long objectId) {
        super(objectId);
    }
    public CompensationRequestProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompensationRequestFacade
            .getCompensationRequest(this.getId());
    }
    
    public long getClassId() {
        return 256;
    }
    
    public PersistentDebitTransfer getDebitTransfer() throws PersistenceException {
        return ((PersistentCompensationRequest)this.getTheObject()).getDebitTransfer();
    }
    public void setDebitTransfer(PersistentDebitTransfer newValue) throws PersistenceException {
        ((PersistentCompensationRequest)this.getTheObject()).setDebitTransfer(newValue);
    }
    public PersistentCompensation getMasterCompensation() throws PersistenceException {
        return ((PersistentCompensationRequest)this.getTheObject()).getMasterCompensation();
    }
    public void setMasterCompensation(PersistentCompensation newValue) throws PersistenceException {
        ((PersistentCompensationRequest)this.getTheObject()).setMasterCompensation(newValue);
    }
    public PersistentCompensationRequestState getState() throws PersistenceException {
        return ((PersistentCompensationRequest)this.getTheObject()).getState();
    }
    public void setState(PersistentCompensationRequestState newValue) throws PersistenceException {
        ((PersistentCompensationRequest)this.getTheObject()).setState(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentCompensationRequest)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentCompensationRequest)this.getTheObject()).setSubService(newValue);
    }
    public PersistentCompensationRequest getThis() throws PersistenceException {
        return ((PersistentCompensationRequest)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequest(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequest(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequest(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequest(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequest(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequest(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequest(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequest(this);
    }
    
    
    public void changeState(final PersistentCompensationRequestState a) 
				throws PersistenceException{
        ((PersistentCompensationRequest)this.getTheObject()).changeState(a);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationRequest)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompensationRequest)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationRequest)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCompensationRequest)this.getTheObject()).updateObservers(event);
    }
    public void changeStateImplementation(final PersistentCompensationRequestState a) 
				throws PersistenceException{
        ((PersistentCompensationRequest)this.getTheObject()).changeStateImplementation(a);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompensationRequest)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompensationRequest)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompensationRequest)this.getTheObject()).initializeOnInstantiation();
    }

    
}
