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
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.IncomingAccountRuleProxi;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentBooleanValue;
import persistence.PersistentDebitTransfer;
import persistence.PersistentIncomingAccountRule;
import persistence.PersistentRule;
import persistence.SubjInterface;
import persistence.TDObserver;

/* Additional import section end */

public class IncomingAccountRule extends model.Rule implements PersistentIncomingAccountRule{
    
    
    public static PersistentIncomingAccountRule createIncomingAccountRule() throws PersistenceException{
        return createIncomingAccountRule(false);
    }
    
    public static PersistentIncomingAccountRule createIncomingAccountRule(boolean delayed$Persistence) throws PersistenceException {
        PersistentIncomingAccountRule result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theIncomingAccountRuleFacade
                .newDelayedIncomingAccountRule(0,0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theIncomingAccountRuleFacade
                .newIncomingAccountRule(0,0,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentIncomingAccountRule createIncomingAccountRule(boolean delayed$Persistence,PersistentIncomingAccountRule This) throws PersistenceException {
        PersistentIncomingAccountRule result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theIncomingAccountRuleFacade
                .newDelayedIncomingAccountRule(0,0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theIncomingAccountRuleFacade
                .newIncomingAccountRule(0,0,-1);
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
            result.put("accountNumber", new Long(this.getAccountNumber()).toString());
            result.put("bankNumber", new Long(this.getBankNumber()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public IncomingAccountRule provideCopy() throws PersistenceException{
        IncomingAccountRule result = this;
        result = new IncomingAccountRule(this.subService, 
                                         this.This, 
                                         this.accountNumber, 
                                         this.bankNumber, 
                                         this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long accountNumber;
    protected long bankNumber;
    
    public IncomingAccountRule(SubjInterface subService,PersistentRule This,long accountNumber,long bankNumber,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentRule)This,id);
        this.accountNumber = accountNumber;
        this.bankNumber = bankNumber;        
    }
    
    static public long getTypeId() {
        return 229;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 229) ConnectionHandler.getTheConnectionHandler().theIncomingAccountRuleFacade
            .newIncomingAccountRule(0,0,this.getId());
        super.store();
        
    }
    
    public long getAccountNumber() throws PersistenceException {
        return this.accountNumber;
    }
    public void setAccountNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theIncomingAccountRuleFacade.accountNumberSet(this.getId(), newValue);
        this.accountNumber = newValue;
    }
    public long getBankNumber() throws PersistenceException {
        return this.bankNumber;
    }
    public void setBankNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theIncomingAccountRuleFacade.bankNumberSet(this.getId(), newValue);
        this.bankNumber = newValue;
    }
    public PersistentIncomingAccountRule getThis() throws PersistenceException {
        if(this.This == null){
            PersistentIncomingAccountRule result = new IncomingAccountRuleProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentIncomingAccountRule)this.This;
    }
    
    public void accept(RuleVisitor visitor) throws PersistenceException {
        visitor.handleIncomingAccountRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleIncomingAccountRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleIncomingAccountRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleIncomingAccountRule(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleIncomingAccountRule(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleIncomingAccountRule(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleIncomingAccountRule(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleIncomingAccountRule(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleIncomingAccountRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleIncomingAccountRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleIncomingAccountRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleIncomingAccountRule(this);
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
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentIncomingAccountRule)This);
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
		// TODO: implement method: copyingPrivateUserAttributes

	}
    public void initializeOnCreation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnCreation

	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		// TODO: implement method: initializeOnInstantiation

	}
    
    
    // Start of section that contains overridden operations only.
    
    public PersistentBooleanValue check(final PersistentDebitTransfer debitTransfer) 
				throws PersistenceException{
		if(debitTransfer.getSender().getAccountNumber() == getThis().getAccountNumber() && debitTransfer.getSender().getBank().getBankNumber() == getThis().getBankNumber()){
			return TrueValue.getTheTrueValue();
		}
		return FalseValue.getTheFalseValue();
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
