
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.ObsInterfaceExceptionVisitor;
import model.visitor.ObsInterfaceReturnExceptionVisitor;
import model.visitor.ObsInterfaceReturnVisitor;
import model.visitor.ObsInterfaceVisitor;
import persistence.AccountReceivedDebitGrantProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountReceivedDebitGrant;
import persistence.PersistentDebitGrantListe;
import persistence.PersistentObject;
import persistence.PersistentProxi;


/* Additional import section end */

public class AccountReceivedDebitGrant extends PersistentObject implements PersistentAccountReceivedDebitGrant{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountReceivedDebitGrant getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade.getClass(objectId);
        return (PersistentAccountReceivedDebitGrant)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountReceivedDebitGrant createAccountReceivedDebitGrant() throws PersistenceException{
        return createAccountReceivedDebitGrant(false);
    }
    
    public static PersistentAccountReceivedDebitGrant createAccountReceivedDebitGrant(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountReceivedDebitGrant result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade
                .newDelayedAccountReceivedDebitGrant();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade
                .newAccountReceivedDebitGrant(-1);
        }
        while (!(result instanceof AccountReceivedDebitGrant)) result = (PersistentAccountReceivedDebitGrant)result.getTheObject();
        ((AccountReceivedDebitGrant)result).setThis(result);
        return result;
    }
    
    public AccountReceivedDebitGrant provideCopy() throws PersistenceException{
        AccountReceivedDebitGrant result = this;
        result = new AccountReceivedDebitGrant(this.observer, 
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
    protected PersistentAccountReceivedDebitGrant This;
    
    public AccountReceivedDebitGrant(PersistentAccount observer,PersistentDebitGrantListe observee,PersistentAccountReceivedDebitGrant This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 205;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 205) ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade
            .newAccountReceivedDebitGrant(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade.observerSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAccountReceivedDebitGrant newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountReceivedDebitGrant)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountReceivedDebitGrantFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountReceivedDebitGrant getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountReceivedDebitGrant result = new AccountReceivedDebitGrantProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountReceivedDebitGrant)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().receivedDebitGrant_update((model.meta.DebitGrantListeMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
