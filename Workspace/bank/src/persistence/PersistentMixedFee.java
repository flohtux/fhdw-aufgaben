package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMixedFee extends PersistentTransactionFee {
    
    public PersistentFixTransactionFee getFix() throws PersistenceException ;
    public void setFix(PersistentFixTransactionFee newValue) throws PersistenceException ;
    public PersistentProcentualFee getProcentual() throws PersistenceException ;
    public void setProcentual(PersistentProcentualFee newValue) throws PersistenceException ;
    public PersistentMoney getLimit() throws PersistenceException ;
    public void setLimit(PersistentMoney newValue) throws PersistenceException ;
    public PersistentMixedFee getThis() throws PersistenceException ;
    
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
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

