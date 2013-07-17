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
    
    public void add(final PersistentBank observee) 
				throws PersistenceException;
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentBank,R,E> aggregtion) 
				throws E, PersistenceException;
    public <R> R aggregate(final persistence.Aggregtion<PersistentBank,R> aggregtion) 
				throws PersistenceException;
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentBank,E> procdure) 
				throws E, PersistenceException;
    public void applyToAll(final persistence.Procdure<PersistentBank> procdure) 
				throws PersistenceException;
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentBank,E> predcate) 
				throws E, PersistenceException;
    public void filter(final persistence.Predcate<PersistentBank> predcate) 
				throws PersistenceException;
    public <E extends UserException> SearchListRoot<PersistentBank> findAllException(final persistence.PredcateException<PersistentBank,E> predcate) 
				throws E, PersistenceException;
    public SearchListRoot<PersistentBank> findAll(final persistence.Predcate<PersistentBank> predcate) 
				throws PersistenceException;
    public <E extends UserException> PersistentBank findFirstException(final persistence.PredcateException<PersistentBank,E> predcate) 
				throws E, PersistenceException;
    public PersistentBank findFirst(final persistence.Predcate<PersistentBank> predcate) 
				throws PersistenceException;
    public java.util.Iterator<PersistentBank> iterator() 
				throws PersistenceException;
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentBank,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstFailure(final persistence.Predcate<PersistentBank> predcate) 
				throws PersistenceException;
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentBank,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstSuccess(final persistence.Predcate<PersistentBank> predcate) 
				throws PersistenceException;
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

}

