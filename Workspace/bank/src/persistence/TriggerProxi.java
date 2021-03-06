package persistence;

import model.UserException;

import model.visitor.*;

public class TriggerProxi extends TriggerValueProxi implements PersistentTrigger{
    
    public TriggerProxi(long objectId) {
        super(objectId);
    }
    public TriggerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTriggerFacade
            .getTrigger(this.getId());
    }
    
    public long getClassId() {
        return 231;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentTrigger)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentTrigger)this.getTheObject()).setName(newValue);
    }
    public PersistentTriggerState getState() throws PersistenceException {
        return ((PersistentTrigger)this.getTheObject()).getState();
    }
    public void setState(PersistentTriggerState newValue) throws PersistenceException {
        ((PersistentTrigger)this.getTheObject()).setState(newValue);
    }
    public PersistentDebitTransferTransaction getAction() throws PersistenceException {
        return ((PersistentTrigger)this.getTheObject()).getAction();
    }
    public void setAction(PersistentDebitTransferTransaction newValue) throws PersistenceException {
        ((PersistentTrigger)this.getTheObject()).setAction(newValue);
    }
    public Trigger_RulesProxi getRules() throws PersistenceException {
        return ((PersistentTrigger)this.getTheObject()).getRules();
    }
    public PersistentTrigger getThis() throws PersistenceException {
        return ((PersistentTrigger)this.getTheObject()).getThis();
    }
    
    public void accept(TriggerValueVisitor visitor) throws PersistenceException {
        visitor.handleTrigger(this);
    }
    public <R> R accept(TriggerValueReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTrigger(this);
    }
    public <E extends UserException>  void accept(TriggerValueExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTrigger(this);
    }
    public <R, E extends UserException> R accept(TriggerValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTrigger(this);
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
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).updateObservers(event);
    }
    public void addRule(final PersistentRule rule) 
				throws model.DoubleRuleDefinitionException, PersistenceException{
        ((PersistentTrigger)this.getTheObject()).addRule(rule);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentTriggerValue copy() 
				throws PersistenceException{
        return ((PersistentTrigger)this.getTheObject()).copy();
    }
    public void disable() 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).disable();
    }
    public void enable() 
				throws model.NoRuleDefinitionException, PersistenceException{
        ((PersistentTrigger)this.getTheObject()).enable();
    }
    public void executeTrigger(final PersistentDebitTransfer incomingDebitTransfer, final PersistentAccountService accService) 
				throws model.ExecuteException, PersistenceException{
        ((PersistentTrigger)this.getTheObject()).executeTrigger(incomingDebitTransfer, accService);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentBooleanValue isEnabled() 
				throws PersistenceException{
        return ((PersistentTrigger)this.getTheObject()).isEnabled();
    }

    
}
