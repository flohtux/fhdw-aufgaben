package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAccountDebitTransferTransactions extends Anything, ObsInterface, AbstractPersistentProxi {
    
    public PersistentAccount getObserver() throws PersistenceException ;
    public void setObserver(PersistentAccount newValue) throws PersistenceException ;
    public AccountDebitTransferTransactions_ObserveeProxi getObservee() throws PersistenceException ;
    public PersistentAccountDebitTransferTransactions getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void add(final PersistentDebitTransferTransaction observee) 
				throws PersistenceException;
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentDebitTransferTransaction,R,E> aggregtion) 
				throws E, PersistenceException;
    public <R> R aggregate(final persistence.Aggregtion<PersistentDebitTransferTransaction,R> aggregtion) 
				throws PersistenceException;
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentDebitTransferTransaction,E> procdure) 
				throws E, PersistenceException;
    public void applyToAll(final persistence.Procdure<PersistentDebitTransferTransaction> procdure) 
				throws PersistenceException;
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException;
    public void filter(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException;
    public <E extends UserException> SearchListRoot<PersistentDebitTransferTransaction> findAllException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException;
    public SearchListRoot<PersistentDebitTransferTransaction> findAll(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException;
    public <E extends UserException> PersistentDebitTransferTransaction findFirstException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException;
    public PersistentDebitTransferTransaction findFirst(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException;
    public java.util.Iterator<PersistentDebitTransferTransaction> iterator() 
				throws PersistenceException;
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstFailure(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException;
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstSuccess(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException;
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

}

