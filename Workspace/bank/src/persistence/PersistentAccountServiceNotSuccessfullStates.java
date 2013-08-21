package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAccountServiceNotSuccessfullStates extends Anything, ObsInterface, AbstractPersistentProxi {
    
    public PersistentAccountService getObserver() throws PersistenceException ;
    public void setObserver(PersistentAccountService newValue) throws PersistenceException ;
    public AccountServiceNotSuccessfullStates_ObserveeProxi getObservee() throws PersistenceException ;
    public PersistentAccountServiceNotSuccessfullStates getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void add(final PersistentDebitTransfer observee) 
				throws PersistenceException;
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentDebitTransfer,R,E> aggregtion) 
				throws E, PersistenceException;
    public <R> R aggregate(final persistence.Aggregtion<PersistentDebitTransfer,R> aggregtion) 
				throws PersistenceException;
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentDebitTransfer,E> procdure) 
				throws E, PersistenceException;
    public void applyToAll(final persistence.Procdure<PersistentDebitTransfer> procdure) 
				throws PersistenceException;
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException;
    public void filter(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException;
    public <E extends UserException> SearchListRoot<PersistentDebitTransfer> findAllException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException;
    public SearchListRoot<PersistentDebitTransfer> findAll(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException;
    public <E extends UserException> PersistentDebitTransfer findFirstException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException;
    public PersistentDebitTransfer findFirst(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException;
    public java.util.Iterator<PersistentDebitTransfer> iterator() 
				throws PersistenceException;
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstFailure(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException;
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstSuccess(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException;
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

}

