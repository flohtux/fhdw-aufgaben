package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentBooleanValue extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentBooleanValue getThis() throws PersistenceException ;
    
    public void accept(BooleanValueVisitor visitor) throws PersistenceException;
    public <R> R accept(BooleanValueReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(BooleanValueExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(BooleanValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public boolean isTrue() 
				throws PersistenceException;
    public PersistentBooleanValue or(final PersistentBooleanValue value) 
				throws PersistenceException;

}

