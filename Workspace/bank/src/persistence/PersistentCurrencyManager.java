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
    /**
     * Calculates the compensation amount in reference currency to fit the
     * invariant "all money together is always 0".
     */
    public PersistentAmount calculateExchangeRateCompensationReferenceAmount() 
				throws PersistenceException;
    /**
     * Sets the new exchange rate for the currency.
     */
    public void changeExchangeRate(final PersistentCurrency currency, final PersistentAmount newRate) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    /**
     * Gets the current exchange rate for the currency.
     */
    public PersistentAmount fetchExchangeRate(final PersistentCurrency currency) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    /**
     * Shifts (depending on sign (+/-) increases/decreases) the CurrencyManagers
     * amount in the given currency.
     * Example: a variance of -10 Euro will decrease the Euro stock by 10.
     */
    public void shiftCurrencyStock(final PersistentMoney variance) 
				throws PersistenceException;
    /**
     * Calculates 'what-if-I-changed-now' money in reference currency.
     */
    public PersistentAmount translateMoneyToReferenceWithoutChanging(final PersistentMoney money) 
				throws PersistenceException;
    /**
     * Calculates 'what-if-I-changed-now' money.
     * 
     * Just for checking purposes, resulting money can NOT be used for transactions.
     * Does NOT influence CurrencyManagers currency stock.
     */
    public PersistentMoney translateMoneyWithoutChanging(final PersistentMoney money, final PersistentCurrency target) 
				throws PersistenceException;
    /**
     * Changes given 'money' into 'target' currency.
     * 
     * Really changes old money into new money, thus old money will be invalid
     * and transactions must use the new money.
     * Influences CurrencyManagers currency stock.
     */
    public PersistentMoney translateMoney(final PersistentMoney money, final PersistentCurrency target) 
				throws PersistenceException;

}

