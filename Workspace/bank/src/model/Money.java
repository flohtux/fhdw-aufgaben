
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Money extends PersistentObject implements PersistentMoney{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMoney getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMoneyFacade.getClass(objectId);
        return (PersistentMoney)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentMoney createMoney(PersistentAmount amount,PersistentCurrency currency) throws PersistenceException{
        return createMoney(amount,currency,false);
    }
    
    public static PersistentMoney createMoney(PersistentAmount amount,PersistentCurrency currency,boolean delayed$Persistence) throws PersistenceException {
        PersistentMoney result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMoneyFacade
                .newDelayedMoney();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMoneyFacade
                .newMoney(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("amount", amount);
        final$$Fields.put("currency", currency);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMoney createMoney(PersistentAmount amount,PersistentCurrency currency,boolean delayed$Persistence,PersistentMoney This) throws PersistenceException {
        PersistentMoney result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMoneyFacade
                .newDelayedMoney();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMoneyFacade
                .newMoney(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("amount", amount);
        final$$Fields.put("currency", currency);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot amount = (AbstractPersistentRoot)this.getAmount();
            if (amount != null) {
                result.put("amount", amount.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    amount.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && amount.hasEssentialFields())amount.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot currency = (AbstractPersistentRoot)this.getCurrency();
            if (currency != null) {
                result.put("currency", currency.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    currency.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && currency.hasEssentialFields())currency.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Money provideCopy() throws PersistenceException{
        Money result = this;
        result = new Money(this.amount, 
                           this.currency, 
                           this.subService, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAmount amount;
    protected PersistentCurrency currency;
    protected SubjInterface subService;
    protected PersistentMoney This;
    
    public Money(PersistentAmount amount,PersistentCurrency currency,SubjInterface subService,PersistentMoney This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 148;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 148) ConnectionHandler.getTheConnectionHandler().theMoneyFacade
            .newMoney(this.getId());
        super.store();
        if(this.getAmount() != null){
            this.getAmount().store();
            ConnectionHandler.getTheConnectionHandler().theMoneyFacade.amountSet(this.getId(), getAmount());
        }
        if(this.getCurrency() != null){
            this.getCurrency().store();
            ConnectionHandler.getTheConnectionHandler().theMoneyFacade.currencySet(this.getId(), getCurrency());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theMoneyFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMoneyFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAmount getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(PersistentAmount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.amount)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.amount = (PersistentAmount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMoneyFacade.amountSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theMoneyFacade.currencySet(this.getId(), newValue);
        }
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
            ConnectionHandler.getTheConnectionHandler().theMoneyFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentMoney newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMoney)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMoneyFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMoney getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMoney result = new MoneyProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMoney)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleMoney(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMoney(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMoney(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMoney(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMoney(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMoney(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMoney(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMoney(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getAmount() != null) return 1;
        if (this.getCurrency() != null) return 1;
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
        this.setThis((PersistentMoney)This);
		if(this.equals(This)){
			this.setAmount((PersistentAmount)final$$Fields.get("amount"));
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
    
    public void add(final PersistentMoney money) 
				throws PersistenceException{
    	if(getThis().getCurrency().equals(money.getCurrency())) {
    		getThis().getAmount().setBalance(money.getAmount().getBalance().add(getThis().getAmount().getBalance()));
    		System.out.println("money added this "+getThis().getCurrency()+ " money "+money.getCurrency());
    	}else {
    		//TODO unterschiedliche Währung bei addieren
    		System.out.println("Du bist doof, da du unterschiedliche Währung verwendest!!! :-)");
    	}
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
