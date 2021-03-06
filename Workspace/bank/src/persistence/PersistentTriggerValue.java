package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentTriggerValue extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentTriggerValue getThis() throws PersistenceException ;
    
    public void accept(TriggerValueVisitor visitor) throws PersistenceException;
    public <R> R accept(TriggerValueReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(TriggerValueExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(TriggerValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentTriggerValue copy() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

