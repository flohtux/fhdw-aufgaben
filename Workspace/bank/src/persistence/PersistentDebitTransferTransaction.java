package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentDebitTransferTransaction extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public java.sql.Timestamp getTimestamp() throws PersistenceException ;
    public void setTimestamp(java.sql.Timestamp newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentDebitTransferTransaction getThis() throws PersistenceException ;
    
    public void accept(DebitTransferTransactionVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void execute() 
				throws model.NoPermissionToExecuteDebitTransferException, model.DebitException, model.InvalidBankNumberException, model.InvalidAccountNumberException, PersistenceException;
    public void execute(final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void executeImplementation() 
				throws model.NoPermissionToExecuteDebitTransferException, model.DebitException, model.InvalidBankNumberException, model.InvalidAccountNumberException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

