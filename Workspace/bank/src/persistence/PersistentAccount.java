package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAccount extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public long getAccountNumber() throws PersistenceException ;
    public void setAccountNumber(long newValue) throws PersistenceException ;
    public PersistentMoney getMoney() throws PersistenceException ;
    public void setMoney(PersistentMoney newValue) throws PersistenceException ;
    public PersistentLimitAccount getLimit() throws PersistenceException ;
    public void setLimit(PersistentLimitAccount newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentAccount getThis() throws PersistenceException ;
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void changeCurrency(final PersistentDebitTransfer trans, final PersistentCurrency currency, final Invoker invoker) 
				throws PersistenceException;
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount, final Invoker invoker) 
				throws PersistenceException;
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccountNumber, final Invoker invoker) 
				throws PersistenceException;
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber, final Invoker invoker) 
				throws PersistenceException;
    public void changeSubject(final PersistentDebitTransfer trans, final String subject, final Invoker invoker) 
				throws PersistenceException;
    public void compensationDeclined(final PersistentCompensation compensation, final String reason, final Invoker invoker) 
				throws PersistenceException;
    public void createDebitGrant(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws model.GrantAlreadyGivenException, PersistenceException;
    public void createDebitGrant(final PersistentAccount receiver, final PersistentLimitType limit, final Invoker invoker) 
				throws PersistenceException;
    public PersistentAccountService getAccountService() 
				throws PersistenceException;
    public PersistentAllCompensationListe getAllCompensation() 
				throws PersistenceException;
    public PersistentBank getBank() 
				throws PersistenceException;
    public PersistentAccountDebitTransferTransactions getDebitTransferTransactions() 
				throws PersistenceException;
    public PersistentDebitGrantListe getGrantedDebitGrant() 
				throws PersistenceException;
    public PersistentDebitGrantListePx getReceivedDebitGrant() 
				throws PersistenceException;
    public PersistentTriggerListe getTriggerListe() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void remove(final PersistentAccountPx acc, final PersistentDebitGrantListe list) 
				throws model.NoPermissionToRemoveDebitGrantException, PersistenceException;
    public void setAllCompensation(final PersistentAllCompensationListe allCompensation) 
				throws PersistenceException;
    public void setGrantedDebitGrant(final PersistentDebitGrantListe grantedDebitGrant) 
				throws PersistenceException;
    public void setReceivedDebitGrant(final PersistentDebitGrantListePx receivedDebitGrant) 
				throws PersistenceException;
    public void setTriggerListe(final PersistentTriggerListe triggerListe) 
				throws PersistenceException;
    public void addDebitTransferTransaction(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException;
    public void addToTransactionTemplate(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException;
    public void addToTransactionTrigger(final PersistentTransaction transaction, final String type) 
				throws PersistenceException;
    public void addToTransaction(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException;
    public void allCompensation_update(final model.meta.AllCompensationListeMssgs event) 
				throws PersistenceException;
    public void answerAcceptWithTrigger(final PersistentCompensationRequest a) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException;
    public void answerAccept(final PersistentCompensationRequest a) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException;
    public void answerDecline(final PersistentCompensationRequest a) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException;
    public void changeCurrency(final PersistentDebitTransfer trans, final PersistentCurrency currency) 
				throws PersistenceException;
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException;
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccountNumber) 
				throws PersistenceException;
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException;
    public void changeSubject(final PersistentDebitTransfer trans, final String subject) 
				throws PersistenceException;
    public void checkAllTriggers(final PersistentDebitTransfer incomingDebitTransfer) 
				throws model.ExecuteException, PersistenceException;
    public void compensationDeclined(final PersistentCompensation compensation, final String reason) 
				throws model.CompensationAbortedException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createDebitGrantImplementation(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws model.GrantAlreadyGivenException, PersistenceException;
    public PersistentDebit createDebit() 
				throws PersistenceException;
    public PersistentDebitTransferTransaction createTemplate(final String type) 
				throws PersistenceException;
    public PersistentTransaction createTransaction() 
				throws PersistenceException;
    public PersistentTransfer createTransfer() 
				throws PersistenceException;
    public PersistentTrigger createTrigger(final String name, final PersistentDebitTransferTransaction dtt) 
				throws PersistenceException;
    public void debitTransferTransactions_update(final model.meta.DebitTransferTransactionMssgs event) 
				throws PersistenceException;
    public void executeTransfer(final PersistentDebitTransferTransaction debitTransfer) 
				throws model.NoPermissionToExecuteDebitTransferException, model.ExecuteException, PersistenceException;
    public PersistentTransaction findContainingTransaction(final PersistentDebitTransfer dt) 
				throws PersistenceException;
    public void grantedDebitGrant_update(final model.meta.DebitGrantListeMssgs event) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void receivedDebitGrant_update(final model.meta.DebitGrantListePxMssgs event) 
				throws PersistenceException;
    public void removeFromTransaction(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException;
    public void removeImplementation(final PersistentAccountPx acc, final PersistentDebitGrantListe list) 
				throws model.NoPermissionToRemoveDebitGrantException, PersistenceException;
    public void requestCompensation(final PersistentDebitTransferTransaction dtr) 
				throws model.NoPermissionToAnswerRequestOfForeignAccountException, PersistenceException;
    public void triggerListe_update(final model.meta.TriggerListeMssgs event) 
				throws PersistenceException;

}

