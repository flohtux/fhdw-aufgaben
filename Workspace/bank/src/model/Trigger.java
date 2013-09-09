
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import model.visitor.TriggerStateReturnVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAccountService;
import persistence.PersistentBooleanValue;
import persistence.PersistentDebitTransfer;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentDisabledState;
import persistence.PersistentEnabledState;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentRule;
import persistence.PersistentTrigger;
import persistence.PersistentTriggerState;
import persistence.Predcate;
import persistence.ProcdureException;
import persistence.SubjInterface;
import persistence.TDObserver;
import persistence.TriggerProxi;
import persistence.Trigger_RulesProxi;


/* Additional import section end */

public class Trigger extends PersistentObject implements PersistentTrigger{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentTrigger getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theTriggerFacade.getClass(objectId);
        return (PersistentTrigger)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentTrigger createTrigger(String name) throws PersistenceException{
        return createTrigger(name,false);
    }
    
    public static PersistentTrigger createTrigger(String name,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentTrigger result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTriggerFacade
                .newDelayedTrigger(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTriggerFacade
                .newTrigger(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentTrigger createTrigger(String name,boolean delayed$Persistence,PersistentTrigger This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentTrigger result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTriggerFacade
                .newDelayedTrigger(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTriggerFacade
                .newTrigger(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            AbstractPersistentRoot state = (AbstractPersistentRoot)this.getState();
            if (state != null) {
                result.put("state", state.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    state.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && state.hasEssentialFields())state.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot action = (AbstractPersistentRoot)this.getAction();
            if (action != null) {
                result.put("action", action.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    action.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && action.hasEssentialFields())action.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("rules", this.getRules().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Trigger provideCopy() throws PersistenceException{
        Trigger result = this;
        result = new Trigger(this.name, 
                             this.state, 
                             this.action, 
                             this.subService, 
                             this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected PersistentTriggerState state;
    protected PersistentDebitTransferTransaction action;
    protected Trigger_RulesProxi rules;
    protected SubjInterface subService;
    protected PersistentTrigger This;
    
    public Trigger(String name,PersistentTriggerState state,PersistentDebitTransferTransaction action,SubjInterface subService,PersistentTrigger This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.state = state;
        this.action = action;
        this.rules = new Trigger_RulesProxi(this);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 231;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 231) ConnectionHandler.getTheConnectionHandler().theTriggerFacade
            .newTrigger(name,this.getId());
        super.store();
        if(this.getState() != null){
            this.getState().store();
            ConnectionHandler.getTheConnectionHandler().theTriggerFacade.stateSet(this.getId(), getState());
        }
        if(this.getAction() != null){
            this.getAction().store();
            ConnectionHandler.getTheConnectionHandler().theTriggerFacade.actionSet(this.getId(), getAction());
        }
        this.getRules().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theTriggerFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theTriggerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theTriggerFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentTriggerState getState() throws PersistenceException {
        return this.state;
    }
    public void setState(PersistentTriggerState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.state)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.state = (PersistentTriggerState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTriggerFacade.stateSet(this.getId(), newValue);
        }
    }
    public PersistentDebitTransferTransaction getAction() throws PersistenceException {
        return this.action;
    }
    public void setAction(PersistentDebitTransferTransaction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.action)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.action = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTriggerFacade.actionSet(this.getId(), newValue);
        }
    }
    public Trigger_RulesProxi getRules() throws PersistenceException {
        return this.rules;
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
            ConnectionHandler.getTheConnectionHandler().theTriggerFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentTrigger newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentTrigger)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTriggerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentTrigger getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTrigger result = new TriggerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentTrigger)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTrigger(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTrigger(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTrigger(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTrigger(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTrigger(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTrigger(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTrigger(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTrigger(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getState() != null) return 1;
        if (this.getAction() != null) return 1;
        if (this.getRules().getLength() > 0) return 1;
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
        this.setThis((PersistentTrigger)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
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
    
    public void addRule(final PersistentRule rule) 
				throws model.DoubleRuleDefinitionException, PersistenceException{
    	PersistentRule result = getThis().getRules().findFirst(new Predcate<PersistentRule>() {
			public boolean test(PersistentRule argument) throws PersistenceException {
				return rule.getClassId() == argument.getClassId();
			}
		});
    	if (result != null) {
    		throw new DoubleRuleDefinitionException();
    	}
    	
        getThis().getRules().add(rule);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void disable() 
				throws PersistenceException{
    	getThis().setState(DisabledState.getTheDisabledState());
    }
    public void enable() 
				throws model.NoRuleDefinitionException, PersistenceException{
        if(getThis().getRules().getLength() == 0) {
        	throw new NoRuleDefinitionException();
        }
    	getThis().setState(EnabledState.getTheEnabledState());
        
    }
    public void executeTrigger(final PersistentDebitTransfer incomingDebitTransfer, final PersistentAccountService accService) 
				throws PersistenceException{
    	System.out.println("execTrigger");
    	
    	if (!getThis().isEnabled().isTrue()) {
    		return;
    	}
    	try {
			getThis().getRules().applyToAllException(new ProcdureException<PersistentRule, RuleNotMatchedException>() {
				public void doItTo(PersistentRule argument) throws PersistenceException, RuleNotMatchedException {
					if (!(argument.check(incomingDebitTransfer).isTrue())) {
						throw new RuleNotMatchedException();
					}
					System.out.println("matched");
				}
			});
		} catch (RuleNotMatchedException e) {
			// trigger action will not be executed
			return;
		}
		System.out.println("execute independent");
		PersistentDebitTransferTransaction copy = getThis().getAction().copy();
		accService.getAccount().getDebitTransferTransactions().add(copy);
		copy.changeState(NotExecutedState.createNotExecutedState());
		copy.execute(accService);
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	 getThis().setState(DisabledState.getTheDisabledState());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public PersistentBooleanValue isEnabled() 
				throws PersistenceException{
        return getThis().getState().accept(new TriggerStateReturnVisitor<PersistentBooleanValue>() {
			public PersistentBooleanValue handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException {
				return FalseValue.getTheFalseValue();
			}
			public PersistentBooleanValue handleEnabledState(PersistentEnabledState enabledState) throws PersistenceException {
				return TrueValue.getTheTrueValue();
			}
		});
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
