package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAccountDebitNoteTransferTransactions extends Anything, ObsInterface, AbstractPersistentProxi {
    
    public PersistentAccount getObserver() throws PersistenceException ;
    public void setObserver(PersistentAccount newValue) throws PersistenceException ;
    public AccountDebitNoteTransferTransactions_ObserveeProxi getObservee() throws PersistenceException ;
    public PersistentAccountDebitNoteTransferTransactions getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void add(final PersistentDebitNoteTransferTransaction observee) 
				throws PersistenceException;
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentDebitNoteTransferTransaction,R,E> aggregtion) 
				throws E, PersistenceException;
    public <R> R aggregate(final persistence.Aggregtion<PersistentDebitNoteTransferTransaction,R> aggregtion) 
				throws PersistenceException;
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentDebitNoteTransferTransaction,E> procdure) 
				throws E, PersistenceException;
    public void applyToAll(final persistence.Procdure<PersistentDebitNoteTransferTransaction> procdure) 
				throws PersistenceException;
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentDebitNoteTransferTransaction,E> predcate) 
				throws E, PersistenceException;
    public void filter(final persistence.Predcate<PersistentDebitNoteTransferTransaction> predcate) 
				throws PersistenceException;
    public <E extends UserException> SearchListRoot<PersistentDebitNoteTransferTransaction> findAllException(final persistence.PredcateException<PersistentDebitNoteTransferTransaction,E> predcate) 
				throws E, PersistenceException;
    public SearchListRoot<PersistentDebitNoteTransferTransaction> findAll(final persistence.Predcate<PersistentDebitNoteTransferTransaction> predcate) 
				throws PersistenceException;
    public <E extends UserException> PersistentDebitNoteTransferTransaction findFirstException(final persistence.PredcateException<PersistentDebitNoteTransferTransaction,E> predcate) 
				throws E, PersistenceException;
    public PersistentDebitNoteTransferTransaction findFirst(final persistence.Predcate<PersistentDebitNoteTransferTransaction> predcate) 
				throws PersistenceException;
    public java.util.Iterator<PersistentDebitNoteTransferTransaction> iterator() 
				throws PersistenceException;
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentDebitNoteTransferTransaction,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstFailure(final persistence.Predcate<PersistentDebitNoteTransferTransaction> predcate) 
				throws PersistenceException;
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentDebitNoteTransferTransaction,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstSuccess(final persistence.Predcate<PersistentDebitNoteTransferTransaction> predcate) 
				throws PersistenceException;
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

}

