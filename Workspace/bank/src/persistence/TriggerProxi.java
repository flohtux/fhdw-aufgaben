package persistence;

import model.UserException;

import model.visitor.*;

public class TriggerProxi extends PersistentProxi implements PersistentTrigger{
    
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
    public PersistentDebitTransferTransaction getAction() throws PersistenceException {
        return ((PersistentTrigger)this.getTheObject()).getAction();
    }
    public void setAction(PersistentDebitTransferTransaction newValue) throws PersistenceException {
        ((PersistentTrigger)this.getTheObject()).setAction(newValue);
    }
    public Trigger_RuleProxi getRule() throws PersistenceException {
        return ((PersistentTrigger)this.getTheObject()).getRule();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentTrigger)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentTrigger)this.getTheObject()).setSubService(newValue);
    }
    public PersistentTrigger getThis() throws PersistenceException {
        return ((PersistentTrigger)this.getTheObject()).getThis();
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
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTrigger)this.getTheObject()).initializeOnInstantiation();
    }

    
}
