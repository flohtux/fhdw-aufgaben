package persistence;

import model.UserException;

import model.visitor.*;

public class AccountAllCompensationICProxi extends PersistentInCacheProxiOptimistic implements PersistentAccountAllCompensation{
    
    public AccountAllCompensationICProxi(long objectId) {
        super(objectId);
    }
    public AccountAllCompensationICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade
            .getAccountAllCompensation(this.getId());
    }
    
    public long getClassId() {
        return 271;
    }
    
    public PersistentAccount getObserver() throws PersistenceException {
        return ((PersistentAccountAllCompensation)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentAccountAllCompensation)this.getTheObject()).setObserver(newValue);
    }
    public PersistentAllCompensationListe getObservee() throws PersistenceException {
        return ((PersistentAccountAllCompensation)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentAllCompensationListe newValue) throws PersistenceException {
        ((PersistentAccountAllCompensation)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAccountAllCompensation getThis() throws PersistenceException {
        return ((PersistentAccountAllCompensation)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountAllCompensation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountAllCompensation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountAllCompensation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountAllCompensation(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountAllCompensation(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountAllCompensation(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountAllCompensation(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountAllCompensation(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountAllCompensation)this.getTheObject()).update(event);
    }

    
}
