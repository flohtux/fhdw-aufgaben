package persistence;

import model.UserException;

import model.visitor.*;

public class ErrorDisplayICProxi extends PersistentInCacheProxiOptimistic implements PersistentErrorDisplay{
    
    public ErrorDisplayICProxi(long objectId) {
        super(objectId);
    }
    public ErrorDisplayICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade
            .getErrorDisplay(this.getId());
    }
    
    public long getClassId() {
        return -135;
    }
    
    public String getMessage() throws PersistenceException {
        return ((PersistentErrorDisplay)this.getTheObject()).getMessage();
    }
    public void setMessage(String newValue) throws PersistenceException {
        ((PersistentErrorDisplay)this.getTheObject()).setMessage(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentErrorDisplay)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentErrorDisplay)this.getTheObject()).setSubService(newValue);
    }
    public PersistentErrorDisplay getThis() throws PersistenceException {
        return ((PersistentErrorDisplay)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleErrorDisplay(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErrorDisplay(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErrorDisplay(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErrorDisplay(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleErrorDisplay(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErrorDisplay(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErrorDisplay(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErrorDisplay(this);
    }
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).deregister(observee);
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).register(observee);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).initializeOnInstantiation();
    }

    
}
