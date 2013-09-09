package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAdministrator extends PersistentService {
    
    public PersistentAdministrator getThis() throws PersistenceException ;
    
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
    
    public PersistentAdministratorBanks getBanks() 
				throws PersistenceException;
    public PersistentCurrencyManager getCurrencyManager() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void setCurrencyManager(final PersistentCurrencyManager currencyManager) 
				throws PersistenceException;
    public void banks_update(final model.meta.BankPxMssgs event) 
				throws PersistenceException;
    /**
     * Updates the currency rate for the given currency to the new value.
     */
    public void changeCurrencyRateGUI(final String currencyType, final common.Fraction rate) 
				throws PersistenceException;
    /**
     * Updates the name of the bank.
     */
    public void changeName(final PersistentBank bank, final String name) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    /**
     * Opens a new bank with the given name and initializes it in this administration service.
     */
    public void createBank(final String name) 
				throws PersistenceException;
    public void currencyManager_update(final model.meta.CurrencyManagerMssgs event) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    /**
     * Finds the given bank in this administration system.
     * 
     * @throws model.InvalidBankNumberException if no bank matches
     */
    public PersistentBank searchBankByBankNumber(final long bankNum) 
				throws model.InvalidBankNumberException, PersistenceException;

}

