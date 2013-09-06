package persistence;

import model.UserException;

import model.visitor.*;

public class EnabledStateProxi extends TriggerStateProxi implements PersistentEnabledState{
    
    public EnabledStateProxi(long objectId) {
        super(objectId);
    }
    public EnabledStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theEnabledStateFacade
            .getEnabledState(this.getId());
    }
    
    public long getClassId() {
        return 238;
    }
    
    public PersistentEnabledState getThis() throws PersistenceException {
        return ((PersistentEnabledState)this.getTheObject()).getThis();
    }
    
    public void accept(TriggerStateVisitor visitor) throws PersistenceException {
        visitor.handleEnabledState(this);
    }
    public <R> R accept(TriggerStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEnabledState(this);
    }
    public <E extends UserException>  void accept(TriggerStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEnabledState(this);
    }
    public <R, E extends UserException> R accept(TriggerStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEnabledState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleEnabledState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEnabledState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEnabledState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEnabledState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEnabledState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEnabledState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEnabledState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEnabledState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentEnabledState)this.getTheObject()).deregister(observee);
    }
    public PersistentTrigger getMaster() 
				throws PersistenceException{
        return ((PersistentEnabledState)this.getTheObject()).getMaster();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentEnabledState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentEnabledState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentEnabledState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentEnabledState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentEnabledState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentEnabledState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
