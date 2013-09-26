package persistence;

import model.UserException;

import model.visitor.*;

public class AccountReceivedDebitGrantICProxi extends PersistentInCacheProxiOptimistic implements PersistentAccountReceivedDebitGrant{
    
    public AccountReceivedDebitGrantICProxi(long objectId) {
        super(objectId);
    }
    public AccountReceivedDebitGrantICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade
            .getAccountReceivedDebitGrant(this.getId());
    }
    
    public long getClassId() {
        return 205;
    }
    
    public PersistentAccount getObserver() throws PersistenceException {
        return ((PersistentAccountReceivedDebitGrant)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentAccountReceivedDebitGrant)this.getTheObject()).setObserver(newValue);
    }
    public PersistentDebitGrantListePx getObservee() throws PersistenceException {
        return ((PersistentAccountReceivedDebitGrant)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentDebitGrantListePx newValue) throws PersistenceException {
        ((PersistentAccountReceivedDebitGrant)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAccountReceivedDebitGrant getThis() throws PersistenceException {
        return ((PersistentAccountReceivedDebitGrant)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountReceivedDebitGrant(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountReceivedDebitGrant(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountReceivedDebitGrant(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountReceivedDebitGrant(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountReceivedDebitGrant(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountReceivedDebitGrant(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountReceivedDebitGrant(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountReceivedDebitGrant(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountReceivedDebitGrant)this.getTheObject()).update(event);
    }

    
}
