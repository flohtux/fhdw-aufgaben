package persistence;

import model.UserException;

import model.visitor.*;

public class AdministratorCurrencyManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentAdministratorCurrencyManager{
    
    public AdministratorCurrencyManagerICProxi(long objectId) {
        super(objectId);
    }
    public AdministratorCurrencyManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade
            .getAdministratorCurrencyManager(this.getId());
    }
    
    public long getClassId() {
        return 183;
    }
    
    public PersistentAdministrator getObserver() throws PersistenceException {
        return ((PersistentAdministratorCurrencyManager)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAdministrator newValue) throws PersistenceException {
        ((PersistentAdministratorCurrencyManager)this.getTheObject()).setObserver(newValue);
    }
    public PersistentCurrencyManager getObservee() throws PersistenceException {
        return ((PersistentAdministratorCurrencyManager)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentCurrencyManager newValue) throws PersistenceException {
        ((PersistentAdministratorCurrencyManager)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAdministratorCurrencyManager getThis() throws PersistenceException {
        return ((PersistentAdministratorCurrencyManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAdministratorCurrencyManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministratorCurrencyManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministratorCurrencyManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministratorCurrencyManager(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAdministratorCurrencyManager(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministratorCurrencyManager(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministratorCurrencyManager(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministratorCurrencyManager(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAdministratorCurrencyManager)this.getTheObject()).update(event);
    }

    
}
