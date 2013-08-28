package persistence;

import model.UserException;

import model.visitor.*;

public class AccountMoney2Proxi extends PersistentProxi implements PersistentAccountMoney2{
    
    public AccountMoney2Proxi(long objectId) {
        super(objectId);
    }
    public AccountMoney2Proxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade
            .getAccountMoney2(this.getId());
    }
    
    public long getClassId() {
        return 224;
    }
    
    public PersistentAccount getObserver() throws PersistenceException {
        return ((PersistentAccountMoney2)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentAccountMoney2)this.getTheObject()).setObserver(newValue);
    }
    public PersistentMoney getObservee() throws PersistenceException {
        return ((PersistentAccountMoney2)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentMoney newValue) throws PersistenceException {
        ((PersistentAccountMoney2)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAccountMoney2 getThis() throws PersistenceException {
        return ((PersistentAccountMoney2)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountMoney2(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountMoney2(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountMoney2(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountMoney2(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountMoney2(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountMoney2(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountMoney2(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountMoney2(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountMoney2)this.getTheObject()).update(event);
    }

    
}
