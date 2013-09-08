
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.ObsInterfaceExceptionVisitor;
import model.visitor.ObsInterfaceReturnExceptionVisitor;
import model.visitor.ObsInterfaceReturnVisitor;
import model.visitor.ObsInterfaceVisitor;
import persistence.AccountServiceBankFeesProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAccountService;
import persistence.PersistentAccountServiceBankFees;
import persistence.PersistentBankFees;
import persistence.PersistentObject;
import persistence.PersistentProxi;


/* Additional import section end */

public class AccountServiceBankFees extends PersistentObject implements PersistentAccountServiceBankFees{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountServiceBankFees getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade.getClass(objectId);
        return (PersistentAccountServiceBankFees)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountServiceBankFees createAccountServiceBankFees() throws PersistenceException{
        return createAccountServiceBankFees(false);
    }
    
    public static PersistentAccountServiceBankFees createAccountServiceBankFees(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountServiceBankFees result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade
                .newDelayedAccountServiceBankFees();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade
                .newAccountServiceBankFees(-1);
        }
        while (!(result instanceof AccountServiceBankFees)) result = (PersistentAccountServiceBankFees)result.getTheObject();
        ((AccountServiceBankFees)result).setThis(result);
        return result;
    }
    
    public AccountServiceBankFees provideCopy() throws PersistenceException{
        AccountServiceBankFees result = this;
        result = new AccountServiceBankFees(this.observer, 
                                            this.observee, 
                                            this.This, 
                                            this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountService observer;
    protected PersistentBankFees observee;
    protected PersistentAccountServiceBankFees This;
    
    public AccountServiceBankFees(PersistentAccountService observer,PersistentBankFees observee,PersistentAccountServiceBankFees This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 245;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 245) ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade
            .newAccountServiceBankFees(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentBankFees getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentBankFees newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentBankFees oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentBankFees)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAccountServiceBankFees newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountServiceBankFees)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceBankFeesFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountServiceBankFees getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountServiceBankFees result = new AccountServiceBankFeesProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountServiceBankFees)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceBankFees(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceBankFees(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceBankFees(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceBankFees(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceBankFees(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceBankFees(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceBankFees(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceBankFees(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().bankFees_update((model.meta.BankFeesMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
