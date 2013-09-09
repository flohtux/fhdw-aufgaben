package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentTrigger extends PersistentTriggerValue {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public PersistentTriggerState getState() throws PersistenceException ;
    public void setState(PersistentTriggerState newValue) throws PersistenceException ;
    public PersistentDebitTransferTransaction getAction() throws PersistenceException ;
    public void setAction(PersistentDebitTransferTransaction newValue) throws PersistenceException ;
    public Trigger_RulesProxi getRules() throws PersistenceException ;
    public PersistentTrigger getThis() throws PersistenceException ;
    
    public void accept(TriggerValueVisitor visitor) throws PersistenceException;
    public <R> R accept(TriggerValueReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(TriggerValueExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(TriggerValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
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
    public void addRule(final PersistentRule rule) 
				throws model.DoubleRuleDefinitionException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void disable() 
				throws PersistenceException;
    public void enable() 
				throws model.NoRuleDefinitionException, PersistenceException;
    public void executeTrigger(final PersistentDebitTransfer incomingDebitTransfer, final PersistentAccountService accService) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public PersistentBooleanValue isEnabled() 
				throws PersistenceException;

}

