package persistence;

import model.UserException;

import model.visitor.*;

public class AccountServiceSuccessfullStatesProxi extends PersistentProxi implements PersistentAccountServiceSuccessfullStates{
    
    public AccountServiceSuccessfullStatesProxi(long objectId) {
        super(objectId);
    }
    public AccountServiceSuccessfullStatesProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountServiceSuccessfullStatesFacade
            .getAccountServiceSuccessfullStates(this.getId());
    }
    
    public long getClassId() {
        return 194;
    }
    
    public PersistentAccountService getObserver() throws PersistenceException {
        return ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAccountService newValue) throws PersistenceException {
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).setObserver(newValue);
    }
    public AccountServiceSuccessfullStates_ObserveeProxi getObservee() throws PersistenceException {
        return ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).getObservee();
    }
    public PersistentAccountServiceSuccessfullStates getThis() throws PersistenceException {
        return ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).getThis();
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
    
    
    public void add(final PersistentDebitTransfer observee) 
				throws PersistenceException{
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).add(observee);
    }
    public <E extends UserException,R> R aggregateException(final persistence.AggregtionException<PersistentDebitTransfer,R,E> aggregtion) 
				throws E, PersistenceException{
        return ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentDebitTransfer,R> aggregtion) 
				throws PersistenceException{
        return ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).aggregate(aggregtion);
    }
    public <E extends UserException> void applyToAllException(final persistence.ProcdureException<PersistentDebitTransfer,E> procdure) 
				throws E, PersistenceException{
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentDebitTransfer> procdure) 
				throws PersistenceException{
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).applyToAll(procdure);
    }
    public <E extends UserException> void filterException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException{
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).filter(predcate);
    }
    public <E extends UserException> SearchListRoot<PersistentDebitTransfer> findAllException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).findAllException(predcate);
    }
    public SearchListRoot<PersistentDebitTransfer> findAll(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException{
        return ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).findAll(predcate);
    }
    public <E extends UserException> PersistentDebitTransfer findFirstException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).findFirstException(predcate);
    }
    public PersistentDebitTransfer findFirst(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException{
        return ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).findFirst(predcate);
    }
    public java.util.Iterator<PersistentDebitTransfer> iterator() 
				throws PersistenceException{
        return ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).iterator();
    }
    public <E extends UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException{
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).removeFirstFailure(predcate);
    }
    public <E extends UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentDebitTransfer,E> predcate) 
				throws E, PersistenceException{
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentDebitTransfer> predcate) 
				throws PersistenceException{
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountServiceSuccessfullStates)this.getTheObject()).update(event);
    }

    
}
