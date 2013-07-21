package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentDebitNoteTransfer extends PersistentDebitNoteTransferTransaction {
    
    public PersistentAccount getSender() throws PersistenceException ;
    public void setSender(PersistentAccount newValue) throws PersistenceException ;
    public PersistentAccount getReceiver() throws PersistenceException ;
    public void setReceiver(PersistentAccount newValue) throws PersistenceException ;
    public PersistentMoney getMoney() throws PersistenceException ;
    public void setMoney(PersistentMoney newValue) throws PersistenceException ;
    public abstract PersistentDebitNoteTransfer getThis() throws PersistenceException ;
    
    public void accept(DebitNoteTransferVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitNoteTransferReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitNoteTransferExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitNoteTransferReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

