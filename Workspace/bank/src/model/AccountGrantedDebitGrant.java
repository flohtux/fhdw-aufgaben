
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.ObsInterfaceExceptionVisitor;
import model.visitor.ObsInterfaceReturnExceptionVisitor;
import model.visitor.ObsInterfaceReturnVisitor;
import model.visitor.ObsInterfaceVisitor;
import persistence.AccountGrantedDebitGrantProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountGrantedDebitGrant;
import persistence.PersistentDebitGrantListe;
import persistence.PersistentObject;
import persistence.PersistentProxi;


/* Additional import section end */

public class AccountGrantedDebitGrant extends PersistentObject implements PersistentAccountGrantedDebitGrant{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountGrantedDebitGrant getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade.getClass(objectId);
        return (PersistentAccountGrantedDebitGrant)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountGrantedDebitGrant createAccountGrantedDebitGrant() throws PersistenceException{
        return createAccountGrantedDebitGrant(false);
    }
    
    public static PersistentAccountGrantedDebitGrant createAccountGrantedDebitGrant(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountGrantedDebitGrant result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade
                .newDelayedAccountGrantedDebitGrant();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade
                .newAccountGrantedDebitGrant(-1);
        }
        while (!(result instanceof AccountGrantedDebitGrant)) result = (PersistentAccountGrantedDebitGrant)result.getTheObject();
        ((AccountGrantedDebitGrant)result).setThis(result);
        return result;
    }
    
    public AccountGrantedDebitGrant provideCopy() throws PersistenceException{
        AccountGrantedDebitGrant result = this;
        result = new AccountGrantedDebitGrant(this.observer, 
                                              this.observee, 
                                              this.This, 
                                              this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount observer;
    protected PersistentDebitGrantListe observee;
    protected PersistentAccountGrantedDebitGrant This;
    
    public AccountGrantedDebitGrant(PersistentAccount observer,PersistentDebitGrantListe observee,PersistentAccountGrantedDebitGrant This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 206;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 206) ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade
            .newAccountGrantedDebitGrant(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAccount getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentDebitGrantListe getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentDebitGrantListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentDebitGrantListe oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentDebitGrantListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAccountGrantedDebitGrant newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountGrantedDebitGrant)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountGrantedDebitGrantFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountGrantedDebitGrant getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountGrantedDebitGrant result = new AccountGrantedDebitGrantProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountGrantedDebitGrant)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().grantedDebitGrant_update((model.meta.DebitGrantListeMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
