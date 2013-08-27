package persistence;

import model.UserException;

import model.visitor.*;

public class AccountServiceSuccessfulICProxi extends PersistentInCacheProxiOptimistic implements PersistentAccountServiceSuccessful{
    
    public AccountServiceSuccessfulICProxi(long objectId) {
        super(objectId);
    }
    public AccountServiceSuccessfulICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade
            .getAccountServiceSuccessful(this.getId());
    }
    
    public long getClassId() {
        return 220;
    }
    
    public PersistentAccountService getObserver() throws PersistenceException {
        return ((PersistentAccountServiceSuccessful)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccountService newValue) throws PersistenceException {
        ((PersistentAccountServiceSuccessful)this.getTheObject()).setObserver(newValue);
    }
    public PersistentDebitTransferSuccessful getObservee() throws PersistenceException {
        return ((PersistentAccountServiceSuccessful)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentDebitTransferSuccessful newValue) throws PersistenceException {
        ((PersistentAccountServiceSuccessful)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAccountServiceSuccessful getThis() throws PersistenceException {
        return ((PersistentAccountServiceSuccessful)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceSuccessful(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceSuccessful(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceSuccessful(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceSuccessful(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceSuccessful(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceSuccessful(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceSuccessful(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceSuccessful(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountServiceSuccessful)this.getTheObject()).update(event);
    }

    
}
