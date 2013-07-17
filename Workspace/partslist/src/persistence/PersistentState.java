package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentState extends Invoker, Anything, AbstractPersistentProxi {
    
    public abstract PersistentState getThis() throws PersistenceException ;
    
    public void accept(StateVisitor visitor) throws PersistenceException;
    public <R> R accept(StateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentComponent getMaster() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentMateriallist fetchMateriallist() 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

