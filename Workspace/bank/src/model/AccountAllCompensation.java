
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountAllCompensation extends PersistentObject implements PersistentAccountAllCompensation{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountAllCompensation getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade.getClass(objectId);
        return (PersistentAccountAllCompensation)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountAllCompensation createAccountAllCompensation() throws PersistenceException{
        return createAccountAllCompensation(false);
    }
    
    public static PersistentAccountAllCompensation createAccountAllCompensation(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountAllCompensation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade
                .newDelayedAccountAllCompensation();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade
                .newAccountAllCompensation(-1);
        }
        while (!(result instanceof AccountAllCompensation)) result = (PersistentAccountAllCompensation)result.getTheObject();
        ((AccountAllCompensation)result).setThis(result);
        return result;
    }
    
    public AccountAllCompensation provideCopy() throws PersistenceException{
        AccountAllCompensation result = this;
        result = new AccountAllCompensation(this.observer, 
                                            this.observee, 
                                            this.This, 
                                            this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount observer;
    protected PersistentAllCompensationListe observee;
    protected PersistentAccountAllCompensation This;
    
    public AccountAllCompensation(PersistentAccount observer,PersistentAllCompensationListe observee,PersistentAccountAllCompensation This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 271;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 271) ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade
            .newAccountAllCompensation(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentAllCompensationListe getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentAllCompensationListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentAllCompensationListe oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentAllCompensationListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAccountAllCompensation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountAllCompensation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountAllCompensationFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountAllCompensation getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountAllCompensation result = new AccountAllCompensationProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountAllCompensation)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().allCompensation_update((model.meta.AllCompensationListeMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
