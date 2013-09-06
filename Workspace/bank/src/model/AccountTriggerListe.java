
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.ObsInterfaceExceptionVisitor;
import model.visitor.ObsInterfaceReturnExceptionVisitor;
import model.visitor.ObsInterfaceReturnVisitor;
import model.visitor.ObsInterfaceVisitor;
import persistence.AccountTriggerListeProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountTriggerListe;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentTriggerListe;


/* Additional import section end */

public class AccountTriggerListe extends PersistentObject implements PersistentAccountTriggerListe{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountTriggerListe getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade.getClass(objectId);
        return (PersistentAccountTriggerListe)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountTriggerListe createAccountTriggerListe() throws PersistenceException{
        return createAccountTriggerListe(false);
    }
    
    public static PersistentAccountTriggerListe createAccountTriggerListe(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountTriggerListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade
                .newDelayedAccountTriggerListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade
                .newAccountTriggerListe(-1);
        }
        while (!(result instanceof AccountTriggerListe)) result = (PersistentAccountTriggerListe)result.getTheObject();
        ((AccountTriggerListe)result).setThis(result);
        return result;
    }
    
    public AccountTriggerListe provideCopy() throws PersistenceException{
        AccountTriggerListe result = this;
        result = new AccountTriggerListe(this.observer, 
                                         this.observee, 
                                         this.This, 
                                         this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount observer;
    protected PersistentTriggerListe observee;
    protected PersistentAccountTriggerListe This;
    
    public AccountTriggerListe(PersistentAccount observer,PersistentTriggerListe observee,PersistentAccountTriggerListe This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 235;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 235) ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade
            .newAccountTriggerListe(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentTriggerListe getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentTriggerListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentTriggerListe oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentTriggerListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAccountTriggerListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountTriggerListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountTriggerListeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountTriggerListe getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountTriggerListe result = new AccountTriggerListeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountTriggerListe)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().triggerListe_update((model.meta.TriggerListeMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
