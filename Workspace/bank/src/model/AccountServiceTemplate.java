
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountServiceTemplate extends PersistentObject implements PersistentAccountServiceTemplate{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountServiceTemplate getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade.getClass(objectId);
        return (PersistentAccountServiceTemplate)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountServiceTemplate createAccountServiceTemplate() throws PersistenceException{
        return createAccountServiceTemplate(false);
    }
    
    public static PersistentAccountServiceTemplate createAccountServiceTemplate(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountServiceTemplate result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade
                .newDelayedAccountServiceTemplate();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade
                .newAccountServiceTemplate(-1);
        }
        while (!(result instanceof AccountServiceTemplate)) result = (PersistentAccountServiceTemplate)result.getTheObject();
        ((AccountServiceTemplate)result).setThis(result);
        return result;
    }
    
    public AccountServiceTemplate provideCopy() throws PersistenceException{
        AccountServiceTemplate result = this;
        result = new AccountServiceTemplate(this.observer, 
                                            this.observee, 
                                            this.This, 
                                            this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountService observer;
    protected PersistentDebitTransferTemplate observee;
    protected PersistentAccountServiceTemplate This;
    
    public AccountServiceTemplate(PersistentAccountService observer,PersistentDebitTransferTemplate observee,PersistentAccountServiceTemplate This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 222;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 222) ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade
            .newAccountServiceTemplate(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentDebitTransferTemplate getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentDebitTransferTemplate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentDebitTransferTemplate oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentDebitTransferTemplate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAccountServiceTemplate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountServiceTemplate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceTemplateFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountServiceTemplate getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountServiceTemplate result = new AccountServiceTemplateProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountServiceTemplate)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceTemplate(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceTemplate(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceTemplate(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceTemplate(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceTemplate(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceTemplate(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceTemplate(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceTemplate(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().template_update((model.meta.DebitTransferTemplateMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
