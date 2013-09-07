package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAdministratorBanks extends Anything, ObsInterface, AbstractPersistentProxi {
    
    public PersistentAdministrator getObserver() throws PersistenceException ;
    public void setObserver(PersistentAdministrator newValue) throws PersistenceException ;
    public AdministratorBanks_ObserveeProxi getObservee() throws PersistenceException ;
    public PersistentAdministratorBanks getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void add(final PersistentBankPx observee) 
				throws PersistenceException;
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentBankPx,R,E> aggregtion) 
				throws E, PersistenceException;
    public <R> R aggregate(final persistence.Aggregtion<PersistentBankPx,R> aggregtion) 
				throws PersistenceException;
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentBankPx,E> procdure) 
				throws E, PersistenceException;
    public void applyToAll(final persistence.Procdure<PersistentBankPx> procdure) 
				throws PersistenceException;
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException;
    public void filter(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException;
    public <E extends UserException> SearchListRoot<PersistentBankPx> findAllException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException;
    public SearchListRoot<PersistentBankPx> findAll(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException;
    public <E extends UserException> PersistentBankPx findFirstException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException;
    public PersistentBankPx findFirst(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException;
    public java.util.Iterator<PersistentBankPx> iterator() 
				throws PersistenceException;
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstFailure(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException;
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentBankPx,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstSuccess(final persistence.Predcate<PersistentBankPx> predcate) 
				throws PersistenceException;
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

}

