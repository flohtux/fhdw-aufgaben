package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCompensation extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public PersistentAccount getRequestingAccount() throws PersistenceException ;
    public void setRequestingAccount(PersistentAccount newValue) throws PersistenceException ;
    public PersistentStornoState getStornoState() throws PersistenceException ;
    public void setStornoState(PersistentStornoState newValue) throws PersistenceException ;
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
    public PersistentBooleanValue allAnswered() 
				throws model.CompensationAbortedException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    /**
     * Compensates requested debit Transfers with *-1.
     */
    public void executeCompensation() 
				throws PersistenceException;
    public void initializeDebitTransferTransaction(final PersistentDebitTransferTransaction dtt) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void pendingRequests_update(final model.meta.CompensationRequestMssgs event) 
				throws PersistenceException;
    public void requestCompensationForDebitTransfers(final DebitTransferSearchList debitTransfers) 
				throws PersistenceException;
    public void requestCompensationForDebitTransfer(final PersistentDebitTransfer debitTransfers) 
				throws PersistenceException;

}

