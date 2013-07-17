package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentLimitState extends PersistentAccountLimitState {
    
    public PersistentAmount getBalance() throws PersistenceException ;
    public void setBalance(PersistentAmount newValue) throws PersistenceException ;
    public abstract PersistentLimitState getThis() throws PersistenceException ;
    
    public void accept(LimitStateVisitor visitor) throws PersistenceException;
    public <R> R accept(LimitStateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(LimitStateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(LimitStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

