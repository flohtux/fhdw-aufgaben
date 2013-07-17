package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAccountLimitState extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentAccountLimitState getThis() throws PersistenceException ;
    
    public void accept(AccountLimitStateVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountLimitStateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AccountLimitStateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AccountLimitStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void checkLimit(final PersistentMoney transactionValue) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

