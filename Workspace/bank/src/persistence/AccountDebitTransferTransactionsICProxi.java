package persistence;

import model.UserException;

import model.visitor.*;

public class AccountDebitTransferTransactionsICProxi extends PersistentInCacheProxiOptimistic implements PersistentAccountDebitTransferTransactions{
    
    public AccountDebitTransferTransactionsICProxi(long objectId) {
        super(objectId);
    }
    public AccountDebitTransferTransactionsICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountDebitTransferTransactionsFacade
            .getAccountDebitTransferTransactions(this.getId());
    }
    
    public long getClassId() {
        return 226;
    }
    
    public PersistentAccount getObserver() throws PersistenceException {
        return ((PersistentAccountDebitTransferTransactions)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).setObserver(newValue);
    }
    public AccountDebitTransferTransactions_ObserveeProxi getObservee() throws PersistenceException {
        return ((PersistentAccountDebitTransferTransactions)this.getTheObject()).getObservee();
    }
    public PersistentAccountDebitTransferTransactions getThis() throws PersistenceException {
        return ((PersistentAccountDebitTransferTransactions)this.getTheObject()).getThis();
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
    
    
    public void add(final PersistentDebitTransferTransaction observee) 
				throws PersistenceException{
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).add(observee);
    }
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentDebitTransferTransaction,R,E> aggregtion) 
				throws E, PersistenceException{
        return ((PersistentAccountDebitTransferTransactions)this.getTheObject()).aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentDebitTransferTransaction,R> aggregtion) 
				throws PersistenceException{
        return ((PersistentAccountDebitTransferTransactions)this.getTheObject()).aggregate(aggregtion);
    }
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentDebitTransferTransaction,E> procdure) 
				throws E, PersistenceException{
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentDebitTransferTransaction> procdure) 
				throws PersistenceException{
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).applyToAll(procdure);
    }
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException{
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).filter(predcate);
    }
    public <E extends UserException> SearchListRoot<PersistentDebitTransferTransaction> findAllException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAccountDebitTransferTransactions)this.getTheObject()).findAllException(predcate);
    }
    public SearchListRoot<PersistentDebitTransferTransaction> findAll(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException{
        return ((PersistentAccountDebitTransferTransactions)this.getTheObject()).findAll(predcate);
    }
    public <E extends UserException> PersistentDebitTransferTransaction findFirstException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAccountDebitTransferTransactions)this.getTheObject()).findFirstException(predcate);
    }
    public PersistentDebitTransferTransaction findFirst(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException{
        return ((PersistentAccountDebitTransferTransactions)this.getTheObject()).findFirst(predcate);
    }
    public java.util.Iterator<PersistentDebitTransferTransaction> iterator() 
				throws PersistenceException{
        return ((PersistentAccountDebitTransferTransactions)this.getTheObject()).iterator();
    }
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException{
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).removeFirstFailure(predcate);
    }
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentDebitTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentDebitTransferTransaction> predcate) 
				throws PersistenceException{
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountDebitTransferTransactions)this.getTheObject()).update(event);
    }

    
}
