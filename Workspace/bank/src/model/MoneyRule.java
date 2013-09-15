
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.RuleExceptionVisitor;
import model.visitor.RuleReturnExceptionVisitor;
import model.visitor.RuleReturnVisitor;
import model.visitor.RuleVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MoneyRuleProxi;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAmount;
import persistence.PersistentBooleanValue;
import persistence.PersistentCurrency;
import persistence.PersistentDebitTransfer;
import persistence.PersistentLimitAccount;
import persistence.PersistentMoneyRule;
import persistence.PersistentProxi;
import persistence.PersistentRule;
import persistence.SubjInterface;
import persistence.TDObserver;

import common.Fraction;


/* Additional import section end */

public class MoneyRule extends model.Rule implements PersistentMoneyRule{
    
    
    public static PersistentMoneyRule createMoneyRule(PersistentCurrency currency) throws PersistenceException{
        return createMoneyRule(currency,false);
    }
    
    public static PersistentMoneyRule createMoneyRule(PersistentCurrency currency,boolean delayed$Persistence) throws PersistenceException {
        PersistentMoneyRule result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade
                .newDelayedMoneyRule();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade
                .newMoneyRule(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("currency", currency);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMoneyRule createMoneyRule(PersistentCurrency currency,boolean delayed$Persistence,PersistentMoneyRule This) throws PersistenceException {
        PersistentMoneyRule result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade
                .newDelayedMoneyRule();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade
                .newMoneyRule(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("currency", currency);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot currency = (AbstractPersistentRoot)this.getCurrency();
            if (currency != null) {
                result.put("currency", currency.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    currency.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && currency.hasEssentialFields())currency.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot minLimit = (AbstractPersistentRoot)this.getMinLimit();
            if (minLimit != null) {
                result.put("minLimit", minLimit.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    minLimit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && minLimit.hasEssentialFields())minLimit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot maxLimit = (AbstractPersistentRoot)this.getMaxLimit();
            if (maxLimit != null) {
                result.put("maxLimit", maxLimit.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    maxLimit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && maxLimit.hasEssentialFields())maxLimit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MoneyRule provideCopy() throws PersistenceException{
        MoneyRule result = this;
        result = new MoneyRule(this.subService, 
                               this.This, 
                               this.currency, 
                               this.minLimit, 
                               this.maxLimit, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentCurrency currency;
    protected PersistentAmount minLimit;
    protected PersistentAmount maxLimit;
    
    public MoneyRule(SubjInterface subService,PersistentRule This,PersistentCurrency currency,PersistentAmount minLimit,PersistentAmount maxLimit,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentRule)This,id);
        this.currency = currency;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;        
    }
    
    static public long getTypeId() {
        return 232;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 232) ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade
            .newMoneyRule(this.getId());
        super.store();
        if(this.getCurrency() != null){
            this.getCurrency().store();
            ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade.currencySet(this.getId(), getCurrency());
        }
        if(this.getMinLimit() != null){
            this.getMinLimit().store();
            ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade.minLimitSet(this.getId(), getMinLimit());
        }
        if(this.getMaxLimit() != null){
            this.getMaxLimit().store();
            ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade.maxLimitSet(this.getId(), getMaxLimit());
        }
        
    }
    
    public PersistentCurrency getCurrency() throws PersistenceException {
        return this.currency;
    }
    public void setCurrency(PersistentCurrency newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.currency)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.currency = (PersistentCurrency)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade.currencySet(this.getId(), newValue);
        }
    }
    public PersistentAmount getMinLimit() throws PersistenceException {
        return this.minLimit;
    }
    public void setMinLimit(PersistentAmount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.minLimit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.minLimit = (PersistentAmount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade.minLimitSet(this.getId(), newValue);
        }
    }
    public PersistentAmount getMaxLimit() throws PersistenceException {
        return this.maxLimit;
    }
    public void setMaxLimit(PersistentAmount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.maxLimit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.maxLimit = (PersistentAmount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade.maxLimitSet(this.getId(), newValue);
        }
    }
    public PersistentMoneyRule getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMoneyRule result = new MoneyRuleProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMoneyRule)this.This;
    }
    
    public void accept(RuleVisitor visitor) throws PersistenceException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMoneyRule(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMoneyRule(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMoneyRule(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMasterTrigger() != null) return 1;
        if (this.getMinLimit() != null && this.getMinLimit().getTheObject().getLeafInfo() != 0) return 1;
        if (this.getMaxLimit() != null && this.getMaxLimit().getTheObject().getLeafInfo() != 0) return 1;
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
        this.setThis((PersistentMoneyRule)This);
		if(this.equals(This)){
			this.setCurrency((PersistentCurrency)final$$Fields.get("currency"));
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
    
    public void changeMax(final common.Fraction maxValue) 
				throws PersistenceException{
    	getThis().setMaxLimit(Amount.createAmount(maxValue));
        
    }
    public void changeMin(final common.Fraction minValue) 
				throws PersistenceException{
    	getThis().setMinLimit(Amount.createAmount(minValue));
        
    }
    public PersistentBooleanValue checkMax(final common.Fraction maxValue) 
				throws PersistenceException{
    	if(getThis().getMinLimit().getBalance().greater(maxValue)) {
    		return FalseValue.getTheFalseValue();
    	} else {
    		return TrueValue.getTheTrueValue();
    	}
    }
    public PersistentBooleanValue checkMin(final common.Fraction minValue) 
				throws PersistenceException{
        if(minValue.greater(getThis().getMaxLimit().getBalance())) {
        	return FalseValue.getTheFalseValue();
        } else {
        	return TrueValue.getTheTrueValue();
        }
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setMinLimit(Amount.createAmount(Fraction.Null));
    	getThis().setMaxLimit(Amount.createAmount(Fraction.Null));
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    
    public PersistentBooleanValue check(final PersistentDebitTransfer debitTransfer) 
				throws PersistenceException{
		PersistentLimitAccount l = LimitAccount.createLimitAccount();
		l.setMinLimit(Limit.createLimit(Money.createMoney(getThis().getMinLimit(), getThis().getCurrency())));
		l.setMaxLimit(Limit.createLimit(Money.createMoney(getThis().getMaxLimit(), getThis().getCurrency())));
    	try {
			l.checkLimit(debitTransfer.getMoney());
		} catch (LimitViolatedException e) {
			return FalseValue.getTheFalseValue();
		}
		return TrueValue.getTheTrueValue();
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
