package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCompensationRequestState extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentCompensationRequestState getThis() throws PersistenceException ;
    
    public void accept(CompensationRequestStateVisitor visitor) throws PersistenceException;
    public <R> R accept(CompensationRequestStateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CompensationRequestStateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CompensationRequestStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

