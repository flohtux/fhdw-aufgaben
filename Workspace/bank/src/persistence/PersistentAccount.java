package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAccount extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public Account_DebitNoteTransferTransactionsProxi getDebitNoteTransferTransactions() throws PersistenceException ;
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
    
    public PersistentAccountService getAccountService() 
				throws PersistenceException;
    public PersistentBank getBank() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentTransfer createTransfer() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

