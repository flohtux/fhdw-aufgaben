
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AdministratorCurrencyManager extends PersistentObject implements PersistentAdministratorCurrencyManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAdministratorCurrencyManager getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade.getClass(objectId);
        return (PersistentAdministratorCurrencyManager)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAdministratorCurrencyManager createAdministratorCurrencyManager() throws PersistenceException{
        return createAdministratorCurrencyManager(false);
    }
    
    public static PersistentAdministratorCurrencyManager createAdministratorCurrencyManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentAdministratorCurrencyManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade
                .newDelayedAdministratorCurrencyManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade
                .newAdministratorCurrencyManager(-1);
        }
        while (!(result instanceof AdministratorCurrencyManager)) result = (PersistentAdministratorCurrencyManager)result.getTheObject();
        ((AdministratorCurrencyManager)result).setThis(result);
        return result;
    }
    
    public AdministratorCurrencyManager provideCopy() throws PersistenceException{
        AdministratorCurrencyManager result = this;
        result = new AdministratorCurrencyManager(this.observer, 
                                                  this.observee, 
                                                  this.This, 
                                                  this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAdministrator observer;
    protected PersistentCurrencyManager observee;
    protected PersistentAdministratorCurrencyManager This;
    
    public AdministratorCurrencyManager(PersistentAdministrator observer,PersistentCurrencyManager observee,PersistentAdministratorCurrencyManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 183;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 183) ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade
            .newAdministratorCurrencyManager(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAdministrator getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(PersistentAdministrator newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentAdministrator)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentCurrencyManager getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentCurrencyManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentCurrencyManager oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentCurrencyManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAdministratorCurrencyManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAdministratorCurrencyManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorCurrencyManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAdministratorCurrencyManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAdministratorCurrencyManager result = new AdministratorCurrencyManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAdministratorCurrencyManager)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().currencyManager_update((model.meta.CurrencyManagerMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
