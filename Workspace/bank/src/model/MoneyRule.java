
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class MoneyRule extends model.Rule implements PersistentMoneyRule{
    
    
    public static PersistentMoneyRule createMoneyRule() throws PersistenceException{
        return createMoneyRule(false);
    }
    
    public static PersistentMoneyRule createMoneyRule(boolean delayed$Persistence) throws PersistenceException {
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
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMoneyRule createMoneyRule(boolean delayed$Persistence,PersistentMoneyRule This) throws PersistenceException {
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
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot limitType = (AbstractPersistentRoot)this.getLimitType();
            if (limitType != null) {
                result.put("limitType", limitType.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    limitType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && limitType.hasEssentialFields())limitType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
                               this.limitType, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentLimitType limitType;
    
    public MoneyRule(SubjInterface subService,PersistentRule This,PersistentLimitType limitType,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentRule)This,id);
        this.limitType = limitType;        
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
        if(this.getLimitType() != null){
            this.getLimitType().store();
            ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade.limitTypeSet(this.getId(), getLimitType());
        }
        
    }
    
    public PersistentLimitType getLimitType() throws PersistenceException {
        return this.limitType;
    }
    public void setLimitType(PersistentLimitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.limitType)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.limitType = (PersistentLimitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMoneyRuleFacade.limitTypeSet(this.getId(), newValue);
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
        if (this.getLimitType() != null) return 1;
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
    
    public PersistentBooleanValue check(final PersistentDebitTransfer debitTransfer) 
				throws PersistenceException{
		try {
			getThis().getLimitType().checkLimit(debitTransfer.getMoney());
		} catch (LimitViolatedException e) {
			return FalseValue.getTheFalseValue();
		}
		return TrueValue.getTheTrueValue();
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
