
package model;

import java.math.BigInteger;

import common.Fraction;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class LimitAccount extends PersistentObject implements PersistentLimitAccount{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentLimitAccount getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade.getClass(objectId);
        return (PersistentLimitAccount)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentLimitAccount createLimitAccount() throws PersistenceException{
        return createLimitAccount(false);
    }
    
    public static PersistentLimitAccount createLimitAccount(boolean delayed$Persistence) throws PersistenceException {
        PersistentLimitAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade
                .newDelayedLimitAccount();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade
                .newLimitAccount(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentLimitAccount createLimitAccount(boolean delayed$Persistence,PersistentLimitAccount This) throws PersistenceException {
        PersistentLimitAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade
                .newDelayedLimitAccount();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade
                .newLimitAccount(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
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
            AbstractPersistentRoot account = (AbstractPersistentRoot)this.getAccount();
            if (account != null) {
                result.put("account", account.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    account.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && account.hasEssentialFields())account.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public LimitAccount provideCopy() throws PersistenceException{
        LimitAccount result = this;
        result = new LimitAccount(this.minLimit, 
                                  this.maxLimit, 
                                  this.subService, 
                                  this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentLimitType minLimit;
    protected PersistentLimitType maxLimit;
    protected SubjInterface subService;
    protected PersistentLimitAccount This;
    
    public LimitAccount(PersistentLimitType minLimit,PersistentLimitType maxLimit,SubjInterface subService,PersistentLimitAccount This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 127;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 127) ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade
            .newLimitAccount(this.getId());
        super.store();
        if(this.getMinLimit() != null){
            this.getMinLimit().store();
            ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade.minLimitSet(this.getId(), getMinLimit());
        }
        if(this.getMaxLimit() != null){
            this.getMaxLimit().store();
            ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade.maxLimitSet(this.getId(), getMaxLimit());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentLimitType getMinLimit() throws PersistenceException {
        return this.minLimit;
    }
    public void setMinLimit(PersistentLimitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.minLimit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.minLimit = (PersistentLimitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade.minLimitSet(this.getId(), newValue);
        }
    }
    public PersistentLimitType getMaxLimit() throws PersistenceException {
        return this.maxLimit;
    }
    public void setMaxLimit(PersistentLimitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.maxLimit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.maxLimit = (PersistentLimitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade.maxLimitSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentLimitAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentLimitAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentLimitAccount getThis() throws PersistenceException {
        if(this.This == null){
            PersistentLimitAccount result = new LimitAccountProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentLimitAccount)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleLimitAccount(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLimitAccount(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLimitAccount(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLimitAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLimitAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLimitAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLimitAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLimitAccount(this);
    }
    public int getLeafInfo() throws PersistenceException{
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
    public PersistentAccount getAccount() 
				throws PersistenceException{
        PersistentAccount result = null;
		try {
			if (result == null) result = (PersistentAccount)ConnectionHandler.getTheConnectionHandler().theAccountFacade
							.inverseGetLimit(this.getId(), this.getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentLimitAccount)This);
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
    
    /**
     * Checks if the <money> hurts the account limits.
     * Returns {@link TrueValue} if no limit is hurt else {@link FalseValue}.
     */
    public void checkLimit(final PersistentMoney money) 
				throws model.TransactionDeniedException, PersistenceException{
        //TODO: Was ist mit unterschiedlichen Währungen? Können diese auftreten?
    	
    	final Fraction newAmount = getThis().getAccount().getMoney().getAmount().getBalance().add(money.getAmount().getBalance());
    	if(money.getAmount().getBalance().isPositive()) {
    		System.out.println("Checke MaxLimit" + money + money.getAmount().getBalance() + getThis().getAccount());
    		
    		getThis().getMaxLimit().accept(new LimitTypeExceptionVisitor<TransactionDeniedException>() {
				@Override
				public void handleNoLimit(
						PersistentNoLimit noLimit) throws PersistenceException, TransactionDeniedException {

				}
				@Override
				public void handleLimit(PersistentLimit limit)
						throws PersistenceException, TransactionDeniedException {
					if(newAmount.greater(limit.getMoney().getAmount().getBalance())) {
						throw new TransactionDeniedException("Oberes Limit überschritten!");
					}
				}
			});
    	}else {
    		System.out.println("Checke MinLimit" + money + getThis().getAccount());
    		
    		getThis().getMinLimit().accept(new LimitTypeExceptionVisitor<TransactionDeniedException>() {
				@Override
				public void handleNoLimit(
						PersistentNoLimit noLimit) throws PersistenceException {
				}
				@Override
				public void handleLimit(PersistentLimit limit)
						throws PersistenceException, TransactionDeniedException {
					if (!newAmount.greaterOrEqual(limit.getMoney().getAmount().getBalance())) {
						throw new TransactionDeniedException("Unteres Limit unterschritten!");
					}
				}
			});
    	}
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setMinLimit(NoLimit.getTheNoLimit());
        getThis().setMaxLimit(NoLimit.getTheNoLimit());
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
