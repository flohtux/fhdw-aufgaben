package persistence;

import model.UserException;

import model.visitor.*;

public class DisabledStateICProxi extends TriggerStateICProxi implements PersistentDisabledState{
    
    public DisabledStateICProxi(long objectId) {
        super(objectId);
    }
    public DisabledStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDisabledStateFacade
            .getDisabledState(this.getId());
    }
    
    public long getClassId() {
        return 237;
    }
    
    public PersistentDisabledState getThis() throws PersistenceException {
        return ((PersistentDisabledState)this.getTheObject()).getThis();
    }
    
    public void accept(TriggerStateVisitor visitor) throws PersistenceException {
        visitor.handleDisabledState(this);
    }
    public <R> R accept(TriggerStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDisabledState(this);
    }
    public <E extends UserException>  void accept(TriggerStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDisabledState(this);
    }
    public <R, E extends UserException> R accept(TriggerStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDisabledState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDisabledState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDisabledState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDisabledState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDisabledState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDisabledState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDisabledState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDisabledState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDisabledState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDisabledState)this.getTheObject()).deregister(observee);
    }
    public PersistentTrigger getMaster() 
				throws PersistenceException{
        return ((PersistentDisabledState)this.getTheObject()).getMaster();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDisabledState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDisabledState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDisabledState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDisabledState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDisabledState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDisabledState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
