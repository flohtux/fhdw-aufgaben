package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentService extends Invoker, Remote, SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public Service_ErrorsProxi getErrors() throws PersistenceException ;
    public abstract PersistentService getThis() throws PersistenceException ;
    
    public void accept(ServiceVisitor visitor) throws PersistenceException;
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentServer getAccess() 
				throws PersistenceException;
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void signalChanged(boolean signal) 
				throws PersistenceException;
    public String changePassword(String newPassword1, String newPassword2) 
				throws model.PasswordException, PersistenceException;
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

