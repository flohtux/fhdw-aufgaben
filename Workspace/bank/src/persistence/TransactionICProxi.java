package persistence;

import model.UserException;

import model.visitor.*;

public class TransactionICProxi extends DebitTransferTransactionICProxi implements PersistentTransaction{
    
    public TransactionICProxi(long objectId) {
        super(objectId);
    }
    public TransactionICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTransactionFacade
            .getTransaction(this.getId());
    }
    
    public long getClassId() {
        return 146;
    }
    
    public PersistentDebitTransferListe getDebitTransfer() throws PersistenceException {
        return ((PersistentTransaction)this.getTheObject()).getDebitTransfer();
    }
    public void setDebitTransfer(PersistentDebitTransferListe newValue) throws PersistenceException {
        ((PersistentTransaction)this.getTheObject()).setDebitTransfer(newValue);
    }
    public PersistentTransaction getThis() throws PersistenceException {
        return ((PersistentTransaction)this.getTheObject()).getThis();
    }
    
    public void accept(DebitTransferTransactionVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    
    
    public PersistentDebitTransferDoubleState changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        return ((PersistentTransaction)this.getTheObject()).changeState(newState);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitTransferTransaction execute() 
				throws model.ExecuteException, PersistenceException{
        return ((PersistentTransaction)this.getTheObject()).execute();
    }
    public void execute(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).execute(invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).updateObservers(event);
    }
    public void addToTransaction(final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).addToTransaction(debitTransfer);
    }
    public PersistentDebitTransferDoubleState changeStateImplementation(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        return ((PersistentTransaction)this.getTheObject()).changeStateImplementation(newState);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentDebitTransferTransaction copy() 
				throws PersistenceException{
        return ((PersistentTransaction)this.getTheObject()).copy();
    }
    public PersistentDebitTransferTransaction executeImplementation() 
				throws model.ExecuteException, PersistenceException{
        return ((PersistentTransaction)this.getTheObject()).executeImplementation();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeFromTransaction(final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
        ((PersistentTransaction)this.getTheObject()).removeFromTransaction(debitTransfer);
    }

    
}
