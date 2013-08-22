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
    public Account_GrantedDebitGrantsProxi getGrantedDebitGrants() throws PersistenceException ;
    public Account_ReceivedDebitGrantsProxi getReceivedDebitGrants() throws PersistenceException ;
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
    
    public PersistentAccountService getAccountService() 
				throws PersistenceException;
    public PersistentBank getBank() 
				throws PersistenceException;
    public PersistentAccountDebitTransferTransactions getDebitTransferTransactions() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void changeCurrency(final PersistentDebitTransfer trans, final PersistentCurrency currency) 
				throws PersistenceException;
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException;
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccountNumber) 
				throws PersistenceException;
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createDebitGrant(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws PersistenceException;
    public PersistentDebit createDebit() 
				throws PersistenceException;
    public PersistentTransfer createTransfer() 
				throws PersistenceException;
    public void debitTransferTransactions_update(final model.meta.DebitTransferTransactionMssgs event) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

