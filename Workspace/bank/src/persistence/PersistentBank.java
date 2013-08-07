package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentBank extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public long getBankNumber() throws PersistenceException ;
    public void setBankNumber(long newValue) throws PersistenceException ;
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public long getLastAccountNumber() throws PersistenceException ;
    public void setLastAccountNumber(long newValue) throws PersistenceException ;
    public PersistentTransactionFee getFee() throws PersistenceException ;
    public void setFee(PersistentTransactionFee newValue) throws PersistenceException ;
    public PersistentInternalFee getInternalFee() throws PersistenceException ;
    public void setInternalFee(PersistentInternalFee newValue) throws PersistenceException ;
    public PersistentAccount getOwnAccount() throws PersistenceException ;
    public void setOwnAccount(PersistentAccount newValue) throws PersistenceException ;
    public Bank_AccountsProxi getAccounts() throws PersistenceException ;
    public PersistentAdministrator getAdministrator() throws PersistenceException ;
    public void setAdministrator(PersistentAdministrator newValue) throws PersistenceException ;
    public Bank_CurrentAccountsProxi getCurrentAccounts() throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentBank getThis() throws PersistenceException ;
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void changeName(final String name) 
				throws PersistenceException;
    public void changeName(final String name, final Invoker invoker) 
				throws PersistenceException;
    public void createAccount(final String currencyType, final Invoker invoker) 
				throws PersistenceException;
    public PersistentBankService getBankServices() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void changeNameImplementation(final String name) 
				throws PersistenceException;
    public void changeTransactionFee(final PersistentTransactionFee transfee, final PersistentTransactionFee newFee) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createAccount(final String currencyType) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void receiveTransfer(final PersistentDebitTransfer debitTransfer) 
				throws model.LimitViolatedException, model.InvalidAccountNumberException, PersistenceException;
    public void sendTransfer(final PersistentDebitTransfer debitTransfer) 
				throws model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, PersistenceException;

}

