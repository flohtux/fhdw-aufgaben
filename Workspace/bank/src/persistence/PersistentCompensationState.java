package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCompensationState extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentCompensationState getThis() throws PersistenceException ;
    
    public void accept(CompensationStateVisitor visitor) throws PersistenceException;
    public <R> R accept(CompensationStateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CompensationStateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CompensationStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentCompensation getCompensation() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

