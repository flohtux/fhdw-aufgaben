package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAllCompensationListePendingCompensationRequests extends Anything, ObsInterface, AbstractPersistentProxi {
    
    public PersistentAllCompensationListe getObserver() throws PersistenceException ;
    public void setObserver(PersistentAllCompensationListe newValue) throws PersistenceException ;
    public PersistentCompensationRequestListe getObservee() throws PersistenceException ;
    public void setObservee(PersistentCompensationRequestListe newValue) throws PersistenceException ;
    public PersistentAllCompensationListePendingCompensationRequests getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

}

