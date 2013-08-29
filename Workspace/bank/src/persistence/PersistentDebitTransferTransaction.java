package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentDebitTransferTransaction extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public java.sql.Timestamp getTimestamp() throws PersistenceException ;
    public void setTimestamp(java.sql.Timestamp newValue) throws PersistenceException ;
    public PersistentAccount getSender() throws PersistenceException ;
    public void setSender(PersistentAccount newValue) throws PersistenceException ;
    public PersistentDebitTransferState getState() throws PersistenceException ;
    public void setState(PersistentDebitTransferState newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentDebitTransferTransaction getThis() throws PersistenceException ;
    
    public void accept(DebitTransferTransactionVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentDebitTransferDoubleState changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException;
    public PersistentDebitTransferTransaction execute() 
				throws model.ExecuteException, PersistenceException;
    public void execute(final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public PersistentDebitTransferDoubleState changeStateImplementation(final PersistentDebitTransferState newState) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentDebitTransferTransaction copy() 
				throws PersistenceException;
    public PersistentDebitTransferTransaction executeImplementation() 
				throws model.ExecuteException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

