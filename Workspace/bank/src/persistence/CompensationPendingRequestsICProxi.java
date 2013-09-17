package persistence;

import model.UserException;

import model.visitor.*;

public class CompensationPendingRequestsICProxi extends PersistentInCacheProxiOptimistic implements PersistentCompensationPendingRequests{
    
    public CompensationPendingRequestsICProxi(long objectId) {
        super(objectId);
    }
    public CompensationPendingRequestsICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompensationPendingRequestsFacade
            .getCompensationPendingRequests(this.getId());
    }
    
    public long getClassId() {
        return 257;
    }
    
    public PersistentCompensation getObserver() throws PersistenceException {
        return ((PersistentCompensationPendingRequests)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentCompensation newValue) throws PersistenceException {
        ((PersistentCompensationPendingRequests)this.getTheObject()).setObserver(newValue);
    }
    public CompensationPendingRequests_ObserveeProxi getObservee() throws PersistenceException {
        return ((PersistentCompensationPendingRequests)this.getTheObject()).getObservee();
    }
    public PersistentCompensationPendingRequests getThis() throws PersistenceException {
        return ((PersistentCompensationPendingRequests)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationPendingRequests(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationPendingRequests(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationPendingRequests(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationPendingRequests(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensationPendingRequests(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationPendingRequests(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationPendingRequests(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationPendingRequests(this);
    }
    
    
    public void add(final PersistentCompensationRequest observee) 
				throws PersistenceException{
        ((PersistentCompensationPendingRequests)this.getTheObject()).add(observee);
    }
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentCompensationRequest,R,E> aggregtion) 
				throws E, PersistenceException{
        return ((PersistentCompensationPendingRequests)this.getTheObject()).aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentCompensationRequest,R> aggregtion) 
				throws PersistenceException{
        return ((PersistentCompensationPendingRequests)this.getTheObject()).aggregate(aggregtion);
    }
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentCompensationRequest,E> procdure) 
				throws E, PersistenceException{
        ((PersistentCompensationPendingRequests)this.getTheObject()).applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentCompensationRequest> procdure) 
				throws PersistenceException{
        ((PersistentCompensationPendingRequests)this.getTheObject()).applyToAll(procdure);
    }
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException{
        ((PersistentCompensationPendingRequests)this.getTheObject()).filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException{
        ((PersistentCompensationPendingRequests)this.getTheObject()).filter(predcate);
    }
    public <E extends UserException> SearchListRoot<PersistentCompensationRequest> findAllException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentCompensationPendingRequests)this.getTheObject()).findAllException(predcate);
    }
    public SearchListRoot<PersistentCompensationRequest> findAll(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException{
        return ((PersistentCompensationPendingRequests)this.getTheObject()).findAll(predcate);
    }
    public <E extends UserException> PersistentCompensationRequest findFirstException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentCompensationPendingRequests)this.getTheObject()).findFirstException(predcate);
    }
    public PersistentCompensationRequest findFirst(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException{
        return ((PersistentCompensationPendingRequests)this.getTheObject()).findFirst(predcate);
    }
    public java.util.Iterator<PersistentCompensationRequest> iterator() 
				throws PersistenceException{
        return ((PersistentCompensationPendingRequests)this.getTheObject()).iterator();
    }
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException{
        ((PersistentCompensationPendingRequests)this.getTheObject()).removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException{
        ((PersistentCompensationPendingRequests)this.getTheObject()).removeFirstFailure(predcate);
    }
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException{
        ((PersistentCompensationPendingRequests)this.getTheObject()).removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException{
        ((PersistentCompensationPendingRequests)this.getTheObject()).removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCompensationPendingRequests)this.getTheObject()).update(event);
    }

    
}
