package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentFixTransactionFee extends PersistentTransactionFee {
    
    public PersistentMoney getValue() throws PersistenceException ;
    public void setValue(PersistentMoney newValue) throws PersistenceException ;
    public PersistentFixTransactionFee getThis() throws PersistenceException ;
    
    public void accept(TransactionFeeVisitor visitor) throws PersistenceException;
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

