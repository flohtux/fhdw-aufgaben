package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCurrencyManager extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public CurrencyManager_ExchangeRatesProxi getExchangeRates() throws PersistenceException ;
    public CurrencyManager_CurrencyStockProxi getCurrencyStock() throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentCurrencyManager getThis() throws PersistenceException ;
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public PersistentAmount calculateExchangeRateCompensationReferenceAmount() 
				throws PersistenceException;
    public void changeExchangeRate(final PersistentCurrency currency, final PersistentAmount newRate) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentAmount fetchExchangeRate(final PersistentCurrency currency) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void shiftCurrencyStock(final PersistentMoney variance) 
				throws PersistenceException;
    public PersistentAmount translateMoneyToReferenceWithoutChanging(final PersistentMoney money) 
				throws PersistenceException;
    public PersistentMoney translateMoneyWithoutChanging(final PersistentMoney money, final PersistentCurrency target) 
				throws PersistenceException;
    public PersistentMoney translateMoney(final PersistentMoney money, final PersistentCurrency target) 
				throws PersistenceException;

}

