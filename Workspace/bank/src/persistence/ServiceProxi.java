package persistence;

import model.UserException;

public abstract class ServiceProxi extends PersistentProxi implements PersistentService{
    
    public ServiceProxi(long objectId) {
        super(objectId);
    }
    public ServiceProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentService)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentService)this.getTheObject()).setSubService(newValue);
    }
    public Service_ErrorsProxi getErrors() throws PersistenceException {
        return ((PersistentService)this.getTheObject()).getErrors();
    }
    public abstract PersistentService getThis() throws PersistenceException ;
    
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).deregister(observee);
    }
    public PersistentServer getAccess() 
				throws PersistenceException{
        return ((PersistentService)this.getTheObject()).getAccess();
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).register(observee);
    }
    public void signalChanged(boolean signal) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).signalChanged(signal);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).updateObservers(event);
    }
    public String changePassword(String newPassword1, String newPassword2) 
				throws model.PasswordException, PersistenceException{
        return ((PersistentService)this.getTheObject()).changePassword(newPassword1, newPassword2);
    }
    public void connected(String user) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).initializeOnInstantiation();
    }

    
}
