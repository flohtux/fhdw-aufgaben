package persistence;

import model.UserException;

import model.visitor.*;

public class AccountServiceBankFeesProxi extends PersistentProxi implements PersistentAccountServiceBankFees{
    
    public AccountServiceBankFeesProxi(long objectId) {
        super(objectId);
    }
    public AccountServiceBankFeesProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade
            .getAccountServiceBankFees(this.getId());
    }
    
    public long getClassId() {
        return 245;
    }
    
    public PersistentAccountService getObserver() throws PersistenceException {
        return ((PersistentAccountServiceBankFees)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccountService newValue) throws PersistenceException {
        ((PersistentAccountServiceBankFees)this.getTheObject()).setObserver(newValue);
    }
    public PersistentBankFees getObservee() throws PersistenceException {
        return ((PersistentAccountServiceBankFees)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentBankFees newValue) throws PersistenceException {
        ((PersistentAccountServiceBankFees)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAccountServiceBankFees getThis() throws PersistenceException {
        return ((PersistentAccountServiceBankFees)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceBankFees(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceBankFees(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceBankFees(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceBankFees(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceBankFees(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceBankFees(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceBankFees(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceBankFees(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountServiceBankFees)this.getTheObject()).update(event);
    }

    
}
