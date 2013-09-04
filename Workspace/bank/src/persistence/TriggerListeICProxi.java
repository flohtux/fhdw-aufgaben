package persistence;

import model.UserException;

import model.visitor.*;

public class TriggerListeICProxi extends PersistentInCacheProxiOptimistic implements PersistentTriggerListe{
    
    public TriggerListeICProxi(long objectId) {
        super(objectId);
    }
    public TriggerListeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTriggerListeFacade
            .getTriggerListe(this.getId());
    }
    
    public long getClassId() {
        return 234;
    }
    
    public TriggerListe_TriggersProxi getTriggers() throws PersistenceException {
        return ((PersistentTriggerListe)this.getTheObject()).getTriggers();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentTriggerListe)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentTriggerListe)this.getTheObject()).setSubService(newValue);
    }
    public PersistentTriggerListe getThis() throws PersistenceException {
        return ((PersistentTriggerListe)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTriggerListe(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTriggerListe(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTriggerListe(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTriggerListe(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTriggerListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTriggerListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTriggerListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTriggerListe(this);
    }
    
    
    public void add(final PersistentTrigger t) 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).add(t);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).register(observee);
    }
    public void remove(final PersistentTrigger t) 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).remove(t);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).updateObservers(event);
    }
    public void addImplementation(final PersistentTrigger t) 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).addImplementation(t);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeImplementation(final PersistentTrigger t) 
				throws PersistenceException{
        ((PersistentTriggerListe)this.getTheObject()).removeImplementation(t);
    }

    
}
