package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentTransaction extends PersistentDebitTransferTransaction {
    
    public PersistentDebitTransferListe getDebitTransfer() throws PersistenceException ;
    public void setDebitTransfer(PersistentDebitTransferListe newValue) throws PersistenceException ;
    public PersistentTransaction getThis() throws PersistenceException ;
    
    public void accept(DebitTransferTransactionVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
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
    public void addToTransaction(final DebitTransferSearchList debitTransfer) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void removeFromTransaction(final DebitTransferSearchList debitTransfer) 
				throws PersistenceException;

}

