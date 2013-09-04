package persistence;

import model.UserException;

import model.visitor.*;

public class AccountServiceNotExecutedProxi extends PersistentProxi implements PersistentAccountServiceNotExecuted{
    
    public AccountServiceNotExecutedProxi(long objectId) {
        super(objectId);
    }
    public AccountServiceNotExecutedProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade
            .getAccountServiceNotExecuted(this.getId());
    }
    
    public long getClassId() {
        return 221;
    }
    
    public PersistentAccountService getObserver() throws PersistenceException {
        return ((PersistentAccountServiceNotExecuted)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccountService newValue) throws PersistenceException {
        ((PersistentAccountServiceNotExecuted)this.getTheObject()).setObserver(newValue);
    }
    public PersistentDebitTransferNotExecuted getObservee() throws PersistenceException {
        return ((PersistentAccountServiceNotExecuted)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentDebitTransferNotExecuted newValue) throws PersistenceException {
        ((PersistentAccountServiceNotExecuted)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAccountServiceNotExecuted getThis() throws PersistenceException {
        return ((PersistentAccountServiceNotExecuted)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceNotExecuted(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceNotExecuted(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceNotExecuted(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceNotExecuted(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceNotExecuted(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceNotExecuted(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceNotExecuted(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceNotExecuted(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountServiceNotExecuted)this.getTheObject()).update(event);
    }

    
}
