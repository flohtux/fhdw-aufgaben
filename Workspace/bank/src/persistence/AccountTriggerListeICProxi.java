package persistence;

import model.UserException;

import model.visitor.*;

public class AccountTriggerListeICProxi extends PersistentInCacheProxiOptimistic implements PersistentAccountTriggerListe{
    
    public AccountTriggerListeICProxi(long objectId) {
        super(objectId);
    }
    public AccountTriggerListeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade
            .getAccountTriggerListe(this.getId());
    }
    
    public long getClassId() {
        return 235;
    }
    
    public PersistentAccount getObserver() throws PersistenceException {
        return ((PersistentAccountTriggerListe)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentAccountTriggerListe)this.getTheObject()).setObserver(newValue);
    }
    public PersistentTriggerListe getObservee() throws PersistenceException {
        return ((PersistentAccountTriggerListe)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentTriggerListe newValue) throws PersistenceException {
        ((PersistentAccountTriggerListe)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAccountTriggerListe getThis() throws PersistenceException {
        return ((PersistentAccountTriggerListe)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountTriggerListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountTriggerListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountTriggerListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountTriggerListe(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountTriggerListe(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountTriggerListe(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountTriggerListe(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountTriggerListe(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountTriggerListe)this.getTheObject()).update(event);
    }

    
}
