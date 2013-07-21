package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentLimitType extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentLimitType getThis() throws PersistenceException ;
    
    public void accept(LimitTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(LimitTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(LimitTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(LimitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

