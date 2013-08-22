package persistence;

import model.UserException;

import model.visitor.*;

public class AccountGrantedDebitGrantProxi extends PersistentProxi implements PersistentAccountGrantedDebitGrant{
    
    public AccountGrantedDebitGrantProxi(long objectId) {
        super(objectId);
    }
    public AccountGrantedDebitGrantProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade
            .getAccountGrantedDebitGrant(this.getId());
    }
    
    public long getClassId() {
        return 206;
    }
    
    public PersistentAccount getObserver() throws PersistenceException {
        return ((PersistentAccountGrantedDebitGrant)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentAccountGrantedDebitGrant)this.getTheObject()).setObserver(newValue);
    }
    public PersistentDebitGrantListe getObservee() throws PersistenceException {
        return ((PersistentAccountGrantedDebitGrant)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentDebitGrantListe newValue) throws PersistenceException {
        ((PersistentAccountGrantedDebitGrant)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAccountGrantedDebitGrant getThis() throws PersistenceException {
        return ((PersistentAccountGrantedDebitGrant)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountGrantedDebitGrant(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountGrantedDebitGrant(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountGrantedDebitGrant(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountGrantedDebitGrant(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountGrantedDebitGrant(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountGrantedDebitGrant(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountGrantedDebitGrant(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountGrantedDebitGrant(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountGrantedDebitGrant)this.getTheObject()).update(event);
    }

    
}
