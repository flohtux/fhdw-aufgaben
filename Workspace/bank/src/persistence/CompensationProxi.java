package persistence;

import model.UserException;

import model.visitor.*;

public class CompensationProxi extends PersistentProxi implements PersistentCompensation{
    
    public CompensationProxi(long objectId) {
        super(objectId);
    }
    public CompensationProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompensationFacade
            .getCompensation(this.getId());
    }
    
    public long getClassId() {
        return 254;
    }
    
    public Compensation_TransactionsToBeCompensatedProxi getTransactionsToBeCompensated() throws PersistenceException {
        return ((PersistentCompensation)this.getTheObject()).getTransactionsToBeCompensated();
    }
    public PersistentAccount getRequestingAccount() throws PersistenceException {
        return ((PersistentCompensation)this.getTheObject()).getRequestingAccount();
    }
    public void setRequestingAccount(PersistentAccount newValue) throws PersistenceException {
        ((PersistentCompensation)this.getTheObject()).setRequestingAccount(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentCompensation)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentCompensation)this.getTheObject()).setSubService(newValue);
    }
    public PersistentCompensation getThis() throws PersistenceException {
        return ((PersistentCompensation)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensation(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensation(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensation(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensation(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensation(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensation)this.getTheObject()).deregister(observee);
    }
    public void executeCompensation(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentCompensation)this.getTheObject()).executeCompensation(invoker);
    }
    public PersistentCompensationPendingRequests getPendingRequests() 
				throws PersistenceException{
        return ((PersistentCompensation)this.getTheObject()).getPendingRequests();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompensation)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensation)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCompensation)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompensation)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void executeCompensation() 
				throws PersistenceException{
        ((PersistentCompensation)this.getTheObject()).executeCompensation();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompensation)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompensation)this.getTheObject()).initializeOnInstantiation();
    }
    public void pendingRequests_update(final model.meta.CompensationRequestMssgs event) 
				throws PersistenceException{
        ((PersistentCompensation)this.getTheObject()).pendingRequests_update(event);
    }

    
}
