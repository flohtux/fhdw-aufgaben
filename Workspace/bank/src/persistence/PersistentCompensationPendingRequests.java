package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCompensationPendingRequests extends Anything, ObsInterface, AbstractPersistentProxi {
    
    public PersistentCompensation getObserver() throws PersistenceException ;
    public void setObserver(PersistentCompensation newValue) throws PersistenceException ;
    public CompensationPendingRequests_ObserveeProxi getObservee() throws PersistenceException ;
    public PersistentCompensationPendingRequests getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void add(final PersistentCompensationRequest observee) 
				throws PersistenceException;
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentCompensationRequest,R,E> aggregtion) 
				throws E, PersistenceException;
    public <R> R aggregate(final persistence.Aggregtion<PersistentCompensationRequest,R> aggregtion) 
				throws PersistenceException;
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentCompensationRequest,E> procdure) 
				throws E, PersistenceException;
    public void applyToAll(final persistence.Procdure<PersistentCompensationRequest> procdure) 
				throws PersistenceException;
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException;
    public void filter(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException;
    public <E extends UserException> SearchListRoot<PersistentCompensationRequest> findAllException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException;
    public SearchListRoot<PersistentCompensationRequest> findAll(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException;
    public <E extends UserException> PersistentCompensationRequest findFirstException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException;
    public PersistentCompensationRequest findFirst(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException;
    public java.util.Iterator<PersistentCompensationRequest> iterator() 
				throws PersistenceException;
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstFailure(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException;
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentCompensationRequest,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstSuccess(final persistence.Predcate<PersistentCompensationRequest> predcate) 
				throws PersistenceException;
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

}

