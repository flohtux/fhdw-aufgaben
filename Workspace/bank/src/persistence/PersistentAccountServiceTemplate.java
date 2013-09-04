package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAccountServiceTemplate extends Anything, ObsInterface, AbstractPersistentProxi {
    
    public PersistentAccountService getObserver() throws PersistenceException ;
    public void setObserver(PersistentAccountService newValue) throws PersistenceException ;
    public PersistentDebitTransferTemplate getObservee() throws PersistenceException ;
    public void setObservee(PersistentDebitTransferTemplate newValue) throws PersistenceException ;
    public PersistentAccountServiceTemplate getThis() throws PersistenceException ;
    
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

