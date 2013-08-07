package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentDebitNoteTransferTransaction extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentDebitNoteTransferTransaction getThis() throws PersistenceException ;
    
    public void accept(DebitNoteTransferTransactionVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitNoteTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitNoteTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitNoteTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void execute() 
				throws model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, model.NoPermissionToExecuteDebitNoteTransferException, PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void executeImplementation() 
				throws model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, model.NoPermissionToExecuteDebitNoteTransferException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

