package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentTransfer extends PersistentDebitNoteTransfer {
    
    public PersistentTransfer getThis() throws PersistenceException ;
    
    public void accept(DebitNoteTransferVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitNoteTransferReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitNoteTransferExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitNoteTransferReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(DebitNoteTransferTransactionVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitNoteTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitNoteTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitNoteTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
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

