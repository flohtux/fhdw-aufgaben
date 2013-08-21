
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountServiceNotSuccessfullStates extends PersistentObject implements PersistentAccountServiceNotSuccessfullStates{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountServiceNotSuccessfullStates getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountServiceNotSuccessfullStatesFacade.getClass(objectId);
        return (PersistentAccountServiceNotSuccessfullStates)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountServiceNotSuccessfullStates createAccountServiceNotSuccessfullStates() throws PersistenceException{
        return createAccountServiceNotSuccessfullStates(false);
    }
    
    public static PersistentAccountServiceNotSuccessfullStates createAccountServiceNotSuccessfullStates(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountServiceNotSuccessfullStates result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceNotSuccessfullStatesFacade
                .newDelayedAccountServiceNotSuccessfullStates();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountServiceNotSuccessfullStatesFacade
                .newAccountServiceNotSuccessfullStates(-1);
        }
        while (!(result instanceof AccountServiceNotSuccessfullStates)) result = (PersistentAccountServiceNotSuccessfullStates)result.getTheObject();
        ((AccountServiceNotSuccessfullStates)result).setThis(result);
        return result;
    }
    
    public AccountServiceNotSuccessfullStates provideCopy() throws PersistenceException{
        AccountServiceNotSuccessfullStates result = this;
        result = new AccountServiceNotSuccessfullStates(this.observer, 
                                                        this.This, 
                                                        this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountService observer;
    protected AccountServiceNotSuccessfullStates_ObserveeProxi observee;
    protected PersistentAccountServiceNotSuccessfullStates This;
    
    public AccountServiceNotSuccessfullStates(PersistentAccountService observer,PersistentAccountServiceNotSuccessfullStates This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = new AccountServiceNotSuccessfullStates_ObserveeProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 195;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 195) ConnectionHandler.getTheConnectionHandler().theAccountServiceNotSuccessfullStatesFacade
            .newAccountServiceNotSuccessfullStates(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceNotSuccessfullStatesFacade.observerSet(this.getId(), getObserver());
        }
        this.getObservee().store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceNotSuccessfullStatesFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAccountServiceNotSuccessfullStatesFacade.observerSet(this.getId(), newValue);
        }
    }
    public AccountServiceNotSuccessfullStates_ObserveeProxi getObservee() throws PersistenceException {
        return this.observee;
    }
    protected void setThis(PersistentAccountServiceNotSuccessfullStates newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountServiceNotSuccessfullStates)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountServiceNotSuccessfullStatesFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountServiceNotSuccessfullStates getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountServiceNotSuccessfullStates result = new AccountServiceNotSuccessfullStatesProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountServiceNotSuccessfullStates)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceNotSuccessfullStates(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceNotSuccessfullStates(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceNotSuccessfullStates(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceNotSuccessfullStates(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountServiceNotSuccessfullStates(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountServiceNotSuccessfullStates(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountServiceNotSuccessfullStates(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountServiceNotSuccessfullStates(this);
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
        this.observer.getThis().notSuccessfullStates_update((model.meta.DebitTransferMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
