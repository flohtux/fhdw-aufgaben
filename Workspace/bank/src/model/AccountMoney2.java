
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountMoney2 extends PersistentObject implements PersistentAccountMoney2{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountMoney2 getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade.getClass(objectId);
        return (PersistentAccountMoney2)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountMoney2 createAccountMoney2() throws PersistenceException{
        return createAccountMoney2(false);
    }
    
    public static PersistentAccountMoney2 createAccountMoney2(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountMoney2 result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade
                .newDelayedAccountMoney2();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade
                .newAccountMoney2(-1);
        }
        while (!(result instanceof AccountMoney2)) result = (PersistentAccountMoney2)result.getTheObject();
        ((AccountMoney2)result).setThis(result);
        return result;
    }
    
    public AccountMoney2 provideCopy() throws PersistenceException{
        AccountMoney2 result = this;
        result = new AccountMoney2(this.observer, 
                                   this.observee, 
                                   this.This, 
                                   this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount observer;
    protected PersistentMoney observee;
    protected PersistentAccountMoney2 This;
    
    public AccountMoney2(PersistentAccount observer,PersistentMoney observee,PersistentAccountMoney2 This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 224;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 224) ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade
            .newAccountMoney2(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentMoney getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentMoney newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentMoney oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentMoney)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAccountMoney2 newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountMoney2)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountMoney2Facade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountMoney2 getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountMoney2 result = new AccountMoney2Proxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountMoney2)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().money2_update((model.meta.MoneyMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
