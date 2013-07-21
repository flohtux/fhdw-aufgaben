package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentTransactionFee extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentTransactionFee getThis() throws PersistenceException ;
    
    public void accept(TransactionFeeVisitor visitor) throws PersistenceException;
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

