
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountServiceSuccessfullStates extends PersistentObject implements PersistentAccountServiceSuccessfullStates{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountServiceSuccessfullStates getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfullStatesFacade.getClass(objectId);
        return (PersistentAccountServiceSuccessfullStates)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountServiceSuccessfullStates createAccountServiceSuccessfullStates() throws PersistenceException{
        return createAccountServiceSuccessfullStates(false);
    }
    
    public static PersistentAccountServiceSuccessfullStates createAccountServiceSuccessfullStates(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountServiceSuccessfullStates result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfullStatesFacade
                .newDelayedAccountServiceSuccessfullStates();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfullStatesFacade
                .newAccountServiceSuccessfullStates(-1);
        }
        while (!(result instanceof AccountServiceSuccessfullStates)) result = (PersistentAccountServiceSuccessfullStates)result.getTheObject();
        ((AccountServiceSuccessfullStates)result).setThis(result);
        return result;
    }
    
    public AccountServiceSuccessfullStates provideCopy() throws PersistenceException{
        AccountServiceSuccessfullStates result = this;
        result = new AccountServiceSuccessfullStates(this.observer, 
                                                     this.This, 
                                                     this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountService observer;
    protected AccountServiceSuccessfullStates_ObserveeProxi observee;
    protected PersistentAccountServiceSuccessfullStates This;
    
    public AccountServiceSuccessfullStates(PersistentAccountService observer,PersistentAccountServiceSuccessfullStates This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = new AccountServiceSuccessfullStates_ObserveeProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 194;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 194) ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfullStatesFacade
            .newAccountServiceSuccessfullStates(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfullStatesFacade.observerSet(this.getId(), getObserver());
        }
        this.getObservee().store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfullStatesFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfullStatesFacade.observerSet(this.getId(), newValue);
        }
    }
    public AccountServiceSuccessfullStates_ObserveeProxi getObservee() throws PersistenceException {
        return this.observee;
    }
    protected void setThis(PersistentAccountServiceSuccessfullStates newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountServiceSuccessfullStates)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfullStatesFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountServiceSuccessfullStates getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountServiceSuccessfullStates result = new AccountServiceSuccessfullStatesProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountServiceSuccessfullStates)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceSuccessfullStates(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceSuccessfullStates(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceSuccessfullStates(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceSuccessfullStates(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceSuccessfullStates(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceSuccessfullStates(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceSuccessfullStates(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceSuccessfullStates(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final PersistentDebitTransfer observee) 
				throws PersistenceException{
        this.getObservee().add(observee);
    }
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentDebitTransfer,R,E> aggregtion) 
				throws E, PersistenceException{
        return this.getObservee().aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentDebitTransfer,R> aggregtion) 
				throws PersistenceException{
        return this.getObservee().aggregate(aggregtion);
    }
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentDebitTransfer,E> procdure) 
				throws E, PersistenceException{
        this.getObservee().applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentDebitTransfer> procdure) 
				throws PersistenceException{
        this.getObservee().applyToAll(procdure);
    }
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException{
        this.getObservee().filter(predcate);
    }
    public <E extends UserException> SearchListRoot<PersistentDebitTransfer> findAllException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findAllException(predcate);
    }
    public SearchListRoot<PersistentDebitTransfer> findAll(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException{
        return this.getObservee().findAll(predcate);
    }
    public <E extends UserException> PersistentDebitTransfer findFirstException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findFirstException(predcate);
    }
    public PersistentDebitTransfer findFirst(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException{
        return this.getObservee().findFirst(predcate);
    }
    public java.util.Iterator<PersistentDebitTransfer> iterator() 
				throws PersistenceException{
        return this.getObservee().iterator();
    }
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstFailure(predcate);
    }
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().successfullStates_update((model.meta.DebitTransferMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
