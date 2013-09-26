package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCompensation extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public PersistentAccount getRequestingAccount() throws PersistenceException ;
    public void setRequestingAccount(PersistentAccount newValue) throws PersistenceException ;
    public PersistentCompensationState getState() throws PersistenceException ;
    public void setState(PersistentCompensationState newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentCompensation getThis() throws PersistenceException ;
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void executeCompensation(final Invoker invoker) 
				throws PersistenceException;
    public PersistentCompensationPendingRequests getPendingRequests() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    /**
     * Checks whether there are unanswered requests.
     * @return false, if some requests have not been answered
     * return true, if all requests have been answered positively
     * @throws CompensationAbortedException if at least one request has been declined
     */
    public PersistentBooleanValue allAnswered() 
				throws model.CompensationAbortedException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    /**
     * Compensates requested debit and transfers.
     * Assumes all transfers have been authorized (= all requests have been answered positively).
     */
    public void executeCompensation() 
				throws PersistenceException;
    public void initializeDebitTransferTransaction(final PersistentDebitTransferTransaction dtt) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void pendingRequests_update(final model.meta.CompensationRequestMssgs event) 
				throws PersistenceException;
    public void requestCompensationForDebitTransferTransaction(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException;
    /**
     * Sends compensation requests to all participants in all debits and transfers.
     */
    public void requestCompensationForDebitTransfers(final DebitTransferSearchList debitTransfers) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException;
    /**
     * Sends compensation requests to all participants in the debit or transfer.
     */
    public void requestCompensationForDebitTransfer(final PersistentDebitTransfer debitTransfer) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException;

}

