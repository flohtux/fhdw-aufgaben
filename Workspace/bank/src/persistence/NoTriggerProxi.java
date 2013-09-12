package persistence;

import model.UserException;

import model.visitor.*;

public class NoTriggerProxi extends TriggerValueProxi implements PersistentNoTrigger{
    
    public NoTriggerProxi(long objectId) {
        super(objectId);
    }
    public NoTriggerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNoTriggerFacade
            .getNoTrigger(this.getId());
    }
    
    public long getClassId() {
        return 246;
    }
    
    public PersistentNoTrigger getThis() throws PersistenceException {
        return ((PersistentNoTrigger)this.getTheObject()).getThis();
    }
    
    public void accept(TriggerValueVisitor visitor) throws PersistenceException {
        visitor.handleNoTrigger(this);
    }
    public <R> R accept(TriggerValueReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoTrigger(this);
    }
    public <E extends UserException>  void accept(TriggerValueExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoTrigger(this);
    }
    public <R, E extends UserException> R accept(TriggerValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoTrigger(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNoTrigger(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoTrigger(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoTrigger(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoTrigger(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoTrigger(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoTrigger(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoTrigger(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoTrigger(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoTrigger)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNoTrigger)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoTrigger)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentNoTrigger)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNoTrigger)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentTriggerValue copy() 
				throws PersistenceException{
        return ((PersistentNoTrigger)this.getTheObject()).copy();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNoTrigger)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNoTrigger)this.getTheObject()).initializeOnInstantiation();
    }

    
}
