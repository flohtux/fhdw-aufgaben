package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAccountService extends PersistentService {
    
    public PersistentAccount getAccount() throws PersistenceException ;
    public void setAccount(PersistentAccount newValue) throws PersistenceException ;
    public PersistentEventWrapper getEventhandle() throws PersistenceException ;
    public void setEventhandle(PersistentEventWrapper newValue) throws PersistenceException ;
    public PersistentFeeWrapper getFeeWrapper() throws PersistenceException ;
    public void setFeeWrapper(PersistentFeeWrapper newValue) throws PersistenceException ;
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
    
    public DebitTransferTransactionSearchList debitTransfer_Path_In_AddToTransactionTemplate() 
				throws model.UserException, PersistenceException;
    public DebitTransferTransactionSearchList debitTransfer_Path_In_AddToTransaction() 
				throws model.UserException, PersistenceException;
    public DebitTransferSearchList debitTransfer_Path_In_RemoveFromTransaction(final PersistentTransaction transaction) 
				throws model.UserException, PersistenceException;
    public PersistentDebitTransferNotExecuted getNotExecuted() 
				throws PersistenceException;
    public PersistentDebitTransferSuccessful getSuccessful() 
				throws PersistenceException;
    public PersistentDebitTransferTemplate getTemplate() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void setNotExecuted(final PersistentDebitTransferNotExecuted notExecuted) 
				throws PersistenceException;
    public void setSuccessful(final PersistentDebitTransferSuccessful successful) 
				throws PersistenceException;
    public void setTemplate(final PersistentDebitTransferTemplate template) 
				throws PersistenceException;
    public void useTemplate(final PersistentDebitTransferTransaction debitTransferTransaction, final Invoker invoker) 
				throws PersistenceException;
    public void addToTransactionTemplate(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException;
    public void addToTransaction(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException;
    public void changeCurrency(final PersistentDebitTransfer trans, final String currency) 
				throws PersistenceException;
    public void changeIncomingAccountRuleAccountNumber(final PersistentIncomingAccountRule rule, final long newAccNum) 
				throws PersistenceException;
    public void changeIncomingAccountRuleBankNumber(final PersistentIncomingAccountRule rule, final long newBankNum) 
				throws PersistenceException;
    public void changeMoneyRuleMax(final PersistentMoneyRule rule, final common.Fraction maxValue) 
				throws model.MaximumIsLowerThenMinimumException, PersistenceException;
    public void changeMoneyRuleMin(final PersistentMoneyRule rule, final common.Fraction minValue) 
				throws model.MinimumIsHigherThenMaximumException, PersistenceException;
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException;
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccNumber) 
				throws PersistenceException;
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException;
    public void changeSubjectRuleSubject(final PersistentSubjectRule rule, final String newSubject) 
				throws PersistenceException;
    public void changeSubject(final PersistentDebitTransfer trans, final String subject) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createDebitGrant(final PersistentDebitGrantListe debitGrantList, final long receiverBankNumber, final long receiverAccNumber, final String limitType, final common.Fraction amount, final String cur) 
				throws model.GrantAlreadyGivenException, model.InvalidBankNumberException, model.InvalidAccountNumberException, PersistenceException;
    public void createDebit() 
				throws PersistenceException;
    public void createNewRule(final PersistentTrigger t, final String type) 
				throws model.DoubleRuleDefinitionException, PersistenceException;
    public void createTemplate(final String type) 
				throws PersistenceException;
    public void createTransaction() 
				throws PersistenceException;
    public void createTransfer() 
				throws PersistenceException;
    public void createTrigger(final String name, final String type) 
				throws PersistenceException;
    public void disable(final PersistentTrigger t) 
				throws PersistenceException;
    public void enable(final PersistentTrigger t) 
				throws model.NoRuleDefinitionException, PersistenceException;
    public void executeTransfer(final PersistentDebitTransferTransaction debitTransfer) 
				throws model.NoPermissionToExecuteDebitTransferException, model.ExecuteException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void notExecuted_update(final model.meta.DebitTransferNotExecutedMssgs event) 
				throws PersistenceException;
    public void removeFromTransaction(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException;
    public void remove(final PersistentDebitGrant grant) 
				throws PersistenceException;
    public void successful_update(final model.meta.DebitTransferSuccessfulMssgs event) 
				throws PersistenceException;
    public void template_update(final model.meta.DebitTransferTemplateMssgs event) 
				throws PersistenceException;
    public void useTemplate(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException;

}

