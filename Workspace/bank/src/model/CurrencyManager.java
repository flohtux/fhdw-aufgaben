
package model;

import java.util.Iterator;
import java.util.prefs.PreferenceChangeEvent;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.Aggregtion;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.CurrencyManagerProxi;
import persistence.CurrencyManager_CurrencyStockProxi;
import persistence.CurrencyManager_ExchangeRatesGUIProxi;
import persistence.CurrencyManager_ExchangeRatesProxi;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAmount;
import persistence.PersistentCurrency;
import persistence.PersistentCurrencyManager;
import persistence.PersistentExchangeRateWrapper;
import persistence.PersistentMoney;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.SubjInterface;
import persistence.TDObserver;
import common.Fraction;


/* Additional import section end */

public class CurrencyManager extends PersistentObject implements PersistentCurrencyManager{
    
    private static PersistentCurrencyManager theCurrencyManager = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentCurrencyManager getTheCurrencyManager() throws PersistenceException{
        if (theCurrencyManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        CurrencyManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade.getTheCurrencyManager();
                            theCurrencyManager = proxi;
                        }
                        if(proxi.getId() < 0) {
                            proxi.setId(proxi.getId() * -1);
                            proxi.initialize(proxi, new java.util.HashMap<String,Object>());
                            proxi.initializeOnCreation();
                        }
                    } catch (PersistenceException e){
                        exception = e;
                    }
                    synchronized ($$lock){$$lock.notify();}
                }
                PersistentCurrencyManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theCurrencyManager;
                }
            }
            synchronized ($$lock) {
                reset$For$Test = false;
                Initializer initializer = new Initializer();
                new Thread(initializer).start();
                try {$$lock.wait();}catch (InterruptedException e) {} //Need not to be interrupted
                return initializer.getResult();
            }
        }
        return theCurrencyManager;
    }
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("exchangeRatesGUI", this.getExchangeRatesGUI().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("exchangeRates", this.getExchangeRates().getValues().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            result.put("currencyStock", this.getCurrencyStock().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public CurrencyManager provideCopy() throws PersistenceException{
        CurrencyManager result = this;
        result = new CurrencyManager(this.subService, 
                                     this.This, 
                                     this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CurrencyManager_ExchangeRatesGUIProxi exchangeRatesGUI;
    protected CurrencyManager_ExchangeRatesProxi exchangeRates;
    protected CurrencyManager_CurrencyStockProxi currencyStock;
    protected SubjInterface subService;
    protected PersistentCurrencyManager This;
    
    public CurrencyManager(SubjInterface subService,PersistentCurrencyManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.exchangeRatesGUI = new CurrencyManager_ExchangeRatesGUIProxi(this);
        this.exchangeRates = new CurrencyManager_ExchangeRatesProxi(this);
        this.currencyStock = new CurrencyManager_CurrencyStockProxi(this);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 179;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public CurrencyManager_ExchangeRatesGUIProxi getExchangeRatesGUI() throws PersistenceException {
        return this.exchangeRatesGUI;
    }
    public CurrencyManager_ExchangeRatesProxi getExchangeRates() throws PersistenceException {
        return this.exchangeRates;
    }
    public CurrencyManager_CurrencyStockProxi getCurrencyStock() throws PersistenceException {
        return this.currencyStock;
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentCurrencyManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentCurrencyManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCurrencyManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentCurrencyManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCurrencyManager result = new CurrencyManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCurrencyManager)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getExchangeRatesGUI().getLength() > 0) return 1;
        if (this.getCurrencyStock().getLength() > 0) return 1;
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCurrencyManager)This);
		if(this.equals(This)){
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public PersistentAmount calculateExchangeRateCompensationReferenceAmount() 
				throws PersistenceException{
    	PersistentAmount allTogether = getThis().getCurrencyStock().aggregate(new Aggregtion<PersistentMoney, PersistentAmount>() {
			public PersistentAmount neutral() throws PersistenceException {
				return Amount.createAmount(Fraction.Null);
			}
			public PersistentAmount compose(PersistentAmount result, PersistentMoney argument) throws PersistenceException {
				return result.add(getThis().translateMoneyToReferenceWithoutChanging(argument));
			}
		});
    	return Amount.createAmount(allTogether.getBalance().multiply(Fraction.parse("-1")));
    }
    public void changeExchangeRate(final PersistentCurrency currency, final PersistentAmount newRate) 
				throws PersistenceException{
    	getThis().getExchangeRates().put(currency, newRate);
    	getThis().getExchangeRatesGUI().filter(new Predcate<PersistentExchangeRateWrapper>() {
			public boolean test(PersistentExchangeRateWrapper argument) throws PersistenceException {
				return !argument.getCurrency().equals(currency);
			}
		});
    	getThis().getExchangeRatesGUI().add(ExchangeRateWrapper.createExchangeRateWrapper(newRate, currency));
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public PersistentAmount fetchExchangeRate(final PersistentCurrency currency) 
				throws PersistenceException{
    	PersistentAmount c = getThis().getExchangeRates().get(currency);
    	if (c == null) {
    		return Amount.createAmount(Fraction.One);
    	}
    	return c;
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void shiftCurrencyStock(final PersistentMoney variance) 
				throws PersistenceException{
    	PersistentMoney oldMoney = null;
    	Iterator<PersistentMoney> i = getThis().getCurrencyStock().iterator();
    	while (i.hasNext()) {
    		PersistentMoney current = i.next();
    		if (current.getCurrency().equals(variance.getCurrency())){
    			oldMoney = current;
    			i.remove();
    			break;
    		}
    	}
    	PersistentMoney newMoney;
    	if (oldMoney == null) {
    		newMoney = variance;
    	} else {
    		newMoney = oldMoney.add(variance);
    	}
    	
    	getThis().getCurrencyStock().add(newMoney);
    	
    }
    public PersistentAmount translateMoneyToReferenceWithoutChanging(final PersistentMoney money) 
				throws PersistenceException{
    	return Amount.createAmount(money.getAmount().getBalance().multiply(getThis().fetchExchangeRate(money.getCurrency()).getBalance()));
    }
    public PersistentMoney translateMoneyWithoutChanging(final PersistentMoney money, final PersistentCurrency target) 
				throws PersistenceException{
    	Fraction amountInReferenceCurrency = money.getAmount().getBalance().multiply(getThis().fetchExchangeRate(money.getCurrency()).getBalance());
    	return Money.createMoney(Amount.createAmount(amountInReferenceCurrency.divide(getThis().fetchExchangeRate(target).getBalance())), target);
    }
    public PersistentMoney translateMoney(final PersistentMoney money, final PersistentCurrency target) 
				throws PersistenceException{
    	PersistentMoney result = getThis().translateMoneyWithoutChanging(money, target);
    	
    	getThis().shiftCurrencyStock(money.multiply(Fraction.parse("-1")));
    	getThis().shiftCurrencyStock(result);
    	
    	return result;
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
