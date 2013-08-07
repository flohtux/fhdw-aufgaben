package persistence;

import model.UserException;

import model.visitor.*;

public class AccountDebitNoteTransferTransactionsProxi extends PersistentProxi implements PersistentAccountDebitNoteTransferTransactions{
    
    public AccountDebitNoteTransferTransactionsProxi(long objectId) {
        super(objectId);
    }
    public AccountDebitNoteTransferTransactionsProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountDebitNoteTransferTransactionsFacade
            .getAccountDebitNoteTransferTransactions(this.getId());
    }
    
    public long getClassId() {
        return 172;
    }
    
    public PersistentAccount getObserver() throws PersistenceException {
        return ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).setObserver(newValue);
    }
    public AccountDebitNoteTransferTransactions_ObserveeProxi getObservee() throws PersistenceException {
        return ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).getObservee();
    }
    public PersistentAccountDebitNoteTransferTransactions getThis() throws PersistenceException {
        return ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountDebitNoteTransferTransactions(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountDebitNoteTransferTransactions(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountDebitNoteTransferTransactions(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountDebitNoteTransferTransactions(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountDebitNoteTransferTransactions(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountDebitNoteTransferTransactions(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountDebitNoteTransferTransactions(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountDebitNoteTransferTransactions(this);
    }
    
    
    public void add(final PersistentDebitNoteTransferTransaction observee) 
				throws PersistenceException{
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).add(observee);
    }
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentDebitNoteTransferTransaction,R,E> aggregtion) 
				throws E, PersistenceException{
        return ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentDebitNoteTransferTransaction,R> aggregtion) 
				throws PersistenceException{
        return ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).aggregate(aggregtion);
    }
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentDebitNoteTransferTransaction,E> procdure) 
				throws E, PersistenceException{
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentDebitNoteTransferTransaction> procdure) 
				throws PersistenceException{
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).applyToAll(procdure);
    }
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentDebitNoteTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentDebitNoteTransferTransaction> predcate) 
				throws PersistenceException{
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).filter(predcate);
    }
    public <E extends UserException> SearchListRoot<PersistentDebitNoteTransferTransaction> findAllException(final persistence.PredcateException<PersistentDebitNoteTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).findAllException(predcate);
    }
    public SearchListRoot<PersistentDebitNoteTransferTransaction> findAll(final persistence.Predcate<PersistentDebitNoteTransferTransaction> predcate) 
				throws PersistenceException{
        return ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).findAll(predcate);
    }
    public <E extends UserException> PersistentDebitNoteTransferTransaction findFirstException(final persistence.PredcateException<PersistentDebitNoteTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).findFirstException(predcate);
    }
    public PersistentDebitNoteTransferTransaction findFirst(final persistence.Predcate<PersistentDebitNoteTransferTransaction> predcate) 
				throws PersistenceException{
        return ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).findFirst(predcate);
    }
    public java.util.Iterator<PersistentDebitNoteTransferTransaction> iterator() 
				throws PersistenceException{
        return ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).iterator();
    }
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentDebitNoteTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentDebitNoteTransferTransaction> predcate) 
				throws PersistenceException{
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).removeFirstFailure(predcate);
    }
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentDebitNoteTransferTransaction,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentDebitNoteTransferTransaction> predcate) 
				throws PersistenceException{
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountDebitNoteTransferTransactions)this.getTheObject()).update(event);
    }

    
}
