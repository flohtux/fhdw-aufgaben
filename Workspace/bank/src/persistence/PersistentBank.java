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
    public PersistentBankFees getBankFees() throws PersistenceException ;
    public void setBankFees(PersistentBankFees newValue) throws PersistenceException ;
    public PersistentBankOwnAccountPx getOwnAccount() throws PersistenceException ;
    public void setOwnAccount(PersistentBankOwnAccountPx newValue) throws PersistenceException ;
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
    public void addToCurrentAccounts(final PersistentAccount a) 
				throws PersistenceException;
    public void changeInternalFee(final common.Fraction procentual) 
				throws model.NoValidPercentValueException, PersistenceException;
    public void changeNameImplementation(final String name) 
				throws PersistenceException;
    public void changeTransactionFeeToFix(final PersistentMoney fix) 
				throws model.NoValidFeeValueException, PersistenceException;
    public void changeTransactionFeeToMixed(final PersistentMoney fix, final common.Fraction procentual, final PersistentMoney limit) 
				throws model.NoValidPercentValueException, model.NoValidFeeValueException, PersistenceException;
    public void changeTransactionFeeToProcentual(final common.Fraction procentual) 
				throws model.NoValidPercentValueException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createAccount(final String currencyType) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void receiveTransfer(final PersistentDebitTransfer debitTransfer) 
				throws model.DebitException, model.InvalidAccountNumberException, PersistenceException;
    public PersistentAccount searchAccountByAccNumber(final long accNum) 
				throws model.InvalidAccountNumberException, PersistenceException;
    public void sendTransfer(final PersistentDebitTransfer debitTransfer, final PersistentAccount hasToPayFees) 
				throws model.ExecuteException, PersistenceException;

}

