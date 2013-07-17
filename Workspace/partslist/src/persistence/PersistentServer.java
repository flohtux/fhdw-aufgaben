package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentServer extends Invoker, Remote, Anything, AbstractPersistentProxi {
    
    public Server_ComponentsProxi getComponents() throws PersistenceException ;
    public Server_ErrorsProxi getErrors() throws PersistenceException ;
    public String getPassword() throws PersistenceException ;
    public void setPassword(String newValue) throws PersistenceException ;
    public String getUser() throws PersistenceException ;
    public void setUser(String newValue) throws PersistenceException ;
    public long getHackCount() throws PersistenceException ;
    public void setHackCount(long newValue) throws PersistenceException ;
    public java.sql.Timestamp getHackDelay() throws PersistenceException ;
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException ;
    public PersistentServer getThis() throws PersistenceException ;
    
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentPartsListManager getManager() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void signalChanged(final boolean signal) 
				throws PersistenceException;
    public void addComponent(final PersistentProduct product, final PersistentComponent newPart, final long amount) 
				throws model.CycleException, PersistenceException;
    public void clearComponents() 
				throws PersistenceException;
    public void clearErrors() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public long count(final PersistentComponent component) 
				throws PersistenceException;
    public void createComponent(final String name, final String componentType) 
				throws PersistenceException;
    public PersistentMateriallist fetchMateriallist(final PersistentComponent component) 
				throws PersistenceException;
    public PersistentPartsListManager getManager(final TDObserver observer) 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;
    public void importComponent(final String name) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void refreshView() 
				throws PersistenceException;

}

