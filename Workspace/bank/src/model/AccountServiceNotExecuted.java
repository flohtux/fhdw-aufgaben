
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.ObsInterfaceExceptionVisitor;
import model.visitor.ObsInterfaceReturnExceptionVisitor;
import model.visitor.ObsInterfaceReturnVisitor;
import model.visitor.ObsInterfaceVisitor;
import persistence.AccountServiceNotExecutedProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAccountService;
import persistence.PersistentAccountServiceNotExecuted;
import persistence.PersistentDebitTransferNotExecuted;
import persistence.PersistentObject;
import persistence.PersistentProxi;


/* Additional import section end */

public class AccountServiceNotExecuted extends PersistentObject implements PersistentAccountServiceNotExecuted{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountServiceNotExecuted getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade.getClass(objectId);
        return (PersistentAccountServiceNotExecuted)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountServiceNotExecuted createAccountServiceNotExecuted() throws PersistenceException{
        return createAccountServiceNotExecuted(false);
    }
    
    public static PersistentAccountServiceNotExecuted createAccountServiceNotExecuted(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountServiceNotExecuted result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade
                .newDelayedAccountServiceNotExecuted();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade
                .newAccountServiceNotExecuted(-1);
        }
        while (!(result instanceof AccountServiceNotExecuted)) result = (PersistentAccountServiceNotExecuted)result.getTheObject();
        ((AccountServiceNotExecuted)result).setThis(result);
        return result;
    }
    
    public AccountServiceNotExecuted provideCopy() throws PersistenceException{
        AccountServiceNotExecuted result = this;
        result = new AccountServiceNotExecuted(this.observer, 
                                               this.observee, 
                                               this.This, 
                                               this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountService observer;
    protected PersistentDebitTransferNotExecuted observee;
    protected PersistentAccountServiceNotExecuted This;
    
    public AccountServiceNotExecuted(PersistentAccountService observer,PersistentDebitTransferNotExecuted observee,PersistentAccountServiceNotExecuted This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 221;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 221) ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade
            .newAccountServiceNotExecuted(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentDebitTransferNotExecuted getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentDebitTransferNotExecuted newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentDebitTransferNotExecuted oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentDebitTransferNotExecuted)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAccountServiceNotExecuted newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountServiceNotExecuted)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceNotExecutedFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountServiceNotExecuted getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountServiceNotExecuted result = new AccountServiceNotExecutedProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountServiceNotExecuted)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceNotExecuted(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceNotExecuted(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceNotExecuted(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceNotExecuted(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceNotExecuted(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceNotExecuted(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceNotExecuted(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceNotExecuted(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().notExecuted_update((model.meta.DebitTransferNotExecutedMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
