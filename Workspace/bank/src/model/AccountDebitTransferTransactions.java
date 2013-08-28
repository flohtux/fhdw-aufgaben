
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountDebitTransferTransactions extends PersistentObject implements PersistentAccountDebitTransferTransactions{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAccountDebitTransferTransactions getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountDebitTransferTransactionsFacade.getClass(objectId);
        return (PersistentAccountDebitTransferTransactions)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAccountDebitTransferTransactions createAccountDebitTransferTransactions() throws PersistenceException{
        return createAccountDebitTransferTransactions(false);
    }
    
    public static PersistentAccountDebitTransferTransactions createAccountDebitTransferTransactions(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountDebitTransferTransactions result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountDebitTransferTransactionsFacade
                .newDelayedAccountDebitTransferTransactions();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountDebitTransferTransactionsFacade
                .newAccountDebitTransferTransactions(-1);
        }
        while (!(result instanceof AccountDebitTransferTransactions)) result = (PersistentAccountDebitTransferTransactions)result.getTheObject();
        ((AccountDebitTransferTransactions)result).setThis(result);
        return result;
    }
    
    public AccountDebitTransferTransactions provideCopy() throws PersistenceException{
        AccountDebitTransferTransactions result = this;
        result = new AccountDebitTransferTransactions(this.observer, 
                                                      this.This, 
                                                      this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount observer;
    protected AccountDebitTransferTransactions_ObserveeProxi observee;
    protected PersistentAccountDebitTransferTransactions This;
    
    public AccountDebitTransferTransactions(PersistentAccount observer,PersistentAccountDebitTransferTransactions This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = new AccountDebitTransferTransactions_ObserveeProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 226;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 226) ConnectionHandler.getTheConnectionHandler().theAccountDebitTransferTransactionsFacade
            .newAccountDebitTransferTransactions(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountDebitTransferTransactionsFacade.observerSet(this.getId(), getObserver());
        }
        this.getObservee().store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountDebitTransferTransactionsFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAccountDebitTransferTransactionsFacade.observerSet(this.getId(), newValue);
        }
    }
    public AccountDebitTransferTransactions_ObserveeProxi getObservee() throws PersistenceException {
        return this.observee;
    }
    protected void setThis(PersistentAccountDebitTransferTransactions newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountDebitTransferTransactions)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountDebitTransferTransactionsFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountDebitTransferTransactions getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountDebitTransferTransactions result = new AccountDebitTransferTransactionsProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAccountDebitTransferTransactions)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountDebitTransferTransactions(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountDebitTransferTransactions(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountDebitTransferTransactions(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountDebitTransferTransactions(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountDebitTransferTransactions(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountDebitTransferTransactions(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountDebitTransferTransactions(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountDebitTransferTransactions(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final PersistentDebitTransferTransaction observee) 
				throws PersistenceException{
        this.getObservee().add(observee);
    }
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentDebitTransferTransaction,R,E> aggregtion) 
				throws E, PersistenceException{
        return this.getObservee().aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentDebitTransferTransaction,R> aggregtion) 
				throws PersistenceException{
        return this.getObservee().aggregate(aggregtion);
    }
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentDebitTransferTransaction,E> procdure) 
				throws E, PersistenceException{
        this.getObservee().applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentDebitTransferTransaction> procdure) 
				throws PersistenceException{
        this.getObservee().applyToAll(procdure);
    }
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException{
        this.getObservee().filter(predcate);
    }
    public <E extends UserException> SearchListRoot<PersistentDebitTransferTransaction> findAllException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findAllException(predcate);
    }
    public SearchListRoot<PersistentDebitTransferTransaction> findAll(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException{
        return this.getObservee().findAll(predcate);
    }
    public <E extends UserException> PersistentDebitTransferTransaction findFirstException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findFirstException(predcate);
    }
    public PersistentDebitTransferTransaction findFirst(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException{
        return this.getObservee().findFirst(predcate);
    }
    public java.util.Iterator<PersistentDebitTransferTransaction> iterator() 
				throws PersistenceException{
        return this.getObservee().iterator();
    }
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstFailure(predcate);
    }
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().debitTransferTransactions_update((model.meta.DebitTransferTransactionMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
