package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAccountService extends PersistentService {
    
    public PersistentAccount getAccount() throws PersistenceException ;
    public void setAccount(PersistentAccount newValue) throws PersistenceException ;
    public PersistentDebitTransferSuccessful getSuccessful() throws PersistenceException ;
    public void setSuccessful(PersistentDebitTransferSuccessful newValue) throws PersistenceException ;
    public PersistentDebitTransferNotExecuted getNotExecuted() throws PersistenceException ;
    public void setNotExecuted(PersistentDebitTransferNotExecuted newValue) throws PersistenceException ;
    public PersistentDebitTransferTemplate getTemplate() throws PersistenceException ;
    public void setTemplate(PersistentDebitTransferTemplate newValue) throws PersistenceException ;
    public PersistentAccountService getThis() throws PersistenceException ;
    
    public void accept(ServiceVisitor visitor) throws PersistenceException;
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void createDebitGrant(final PersistentDebitGrantListe debitGrantList, final long receiverBankNumber, final long receiverAccNumber, final String limitType, final common.Fraction amount, final String cur, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void useTemplate(final PersistentTransfer transfer, final Invoker invoker) 
				throws PersistenceException;
    public void addToTransaction(final PersistentTransaction transaction, final PersistentDebitTransfer debitTransfer) 
				throws PersistenceException;
    public void changeCurrency(final PersistentDebitTransfer trans, final String currency) 
				throws PersistenceException;
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException;
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccNumber) 
				throws PersistenceException;
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException;
    public void changeSubject(final PersistentDebitTransfer trans, final String subject) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createDebitGrant(final PersistentDebitGrantListe debitGrantList, final long receiverBankNumber, final long receiverAccNumber, final String limitType, final common.Fraction amount, final String cur) 
				throws model.InvalidBankNumberException, model.InvalidAccountNumberException, PersistenceException;
    public void createDebit() 
				throws PersistenceException;
    public void createTemplate(final String type) 
				throws PersistenceException;
    public void createTransaction() 
				throws PersistenceException;
    public void createTransfer() 
				throws PersistenceException;
    public void executeTransfer(final PersistentDebitTransferTransaction debitTransfer) 
				throws model.NoPermissionToExecuteDebitTransferException, model.ExecuteException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void useTemplate(final PersistentTransfer transfer) 
				throws PersistenceException;

}

