package persistence;

import model.UserException;

import model.visitor.*;

public class CurrencyManagerProxi extends PersistentProxi implements PersistentCurrencyManager{
    
    public CurrencyManagerProxi(long objectId) {
        super(objectId);
    }
    public CurrencyManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade
            .getCurrencyManager(this.getId());
    }
    
    public long getClassId() {
        return 179;
    }
    
    public CurrencyManager_ExchangeRatesProxi getExchangeRates() throws PersistenceException {
        return ((PersistentCurrencyManager)this.getTheObject()).getExchangeRates();
    }
    public CurrencyManager_CurrencyStockProxi getCurrencyStock() throws PersistenceException {
        return ((PersistentCurrencyManager)this.getTheObject()).getCurrencyStock();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentCurrencyManager)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentCurrencyManager)this.getTheObject()).setSubService(newValue);
    }
    public PersistentCurrencyManager getThis() throws PersistenceException {
        return ((PersistentCurrencyManager)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCurrencyManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCurrencyManager(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCurrencyManager(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCurrencyManager(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCurrencyManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCurrencyManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCurrencyManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCurrencyManager(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCurrencyManager)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCurrencyManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCurrencyManager)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCurrencyManager)this.getTheObject()).updateObservers(event);
    }
    public PersistentAmount calculateExchangeRateCompensationReferenceAmount() 
				throws PersistenceException{
        return ((PersistentCurrencyManager)this.getTheObject()).calculateExchangeRateCompensationReferenceAmount();
    }
    public void changeExchangeRate(final PersistentCurrency currency, final PersistentAmount newRate) 
				throws PersistenceException{
        ((PersistentCurrencyManager)this.getTheObject()).changeExchangeRate(currency, newRate);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCurrencyManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentAmount fetchExchangeRate(final PersistentCurrency currency) 
				throws PersistenceException{
        return ((PersistentCurrencyManager)this.getTheObject()).fetchExchangeRate(currency);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCurrencyManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCurrencyManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void shiftCurrencyStock(final PersistentMoney variance) 
				throws PersistenceException{
        ((PersistentCurrencyManager)this.getTheObject()).shiftCurrencyStock(variance);
    }
    public PersistentAmount translateMoneyToReferenceWithoutChanging(final PersistentMoney money) 
				throws PersistenceException{
        return ((PersistentCurrencyManager)this.getTheObject()).translateMoneyToReferenceWithoutChanging(money);
    }
    public PersistentMoney translateMoneyWithoutChanging(final PersistentMoney money, final PersistentCurrency target) 
				throws PersistenceException{
        return ((PersistentCurrencyManager)this.getTheObject()).translateMoneyWithoutChanging(money, target);
    }
    public PersistentMoney translateMoney(final PersistentMoney money, final PersistentCurrency target) 
				throws PersistenceException{
        return ((PersistentCurrencyManager)this.getTheObject()).translateMoney(money, target);
    }

    
}
