
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountServiceSuccessful extends PersistentObject implements PersistentAccountServiceSuccessful{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountServiceSuccessful getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade.getClass(objectId);
        return (PersistentAccountServiceSuccessful)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountServiceSuccessful createAccountServiceSuccessful() throws PersistenceException{
        return createAccountServiceSuccessful(false);
    }
    
    public static PersistentAccountServiceSuccessful createAccountServiceSuccessful(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountServiceSuccessful result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade
                .newDelayedAccountServiceSuccessful();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade
                .newAccountServiceSuccessful(-1);
        }
        while (!(result instanceof AccountServiceSuccessful)) result = (PersistentAccountServiceSuccessful)result.getTheObject();
        ((AccountServiceSuccessful)result).setThis(result);
        return result;
    }
    
    public AccountServiceSuccessful provideCopy() throws PersistenceException{
        AccountServiceSuccessful result = this;
        result = new AccountServiceSuccessful(this.observer, 
                                              this.observee, 
                                              this.This, 
                                              this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountService observer;
    protected PersistentDebitTransferSuccessful observee;
    protected PersistentAccountServiceSuccessful This;
    
    public AccountServiceSuccessful(PersistentAccountService observer,PersistentDebitTransferSuccessful observee,PersistentAccountServiceSuccessful This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 199;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 199) ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade
            .newAccountServiceSuccessful(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAccountService getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(PersistentAccountService newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentAccountService)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentDebitTransferSuccessful getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentDebitTransferSuccessful newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentDebitTransferSuccessful oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentDebitTransferSuccessful)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAccountServiceSuccessful newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountServiceSuccessful)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfulFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountServiceSuccessful getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountServiceSuccessful result = new AccountServiceSuccessfulProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountServiceSuccessful)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceSuccessful(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceSuccessful(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceSuccessful(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceSuccessful(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceSuccessful(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceSuccessful(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceSuccessful(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceSuccessful(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().successful_update((model.meta.DebitTransferSuccessfulMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
