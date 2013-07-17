package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentDebitNoteTransaction extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public long getBankNumber() throws PersistenceException ;
    public void setBankNumber(long newValue) throws PersistenceException ;
    public long getAccountNumber() throws PersistenceException ;
    public void setAccountNumber(long newValue) throws PersistenceException ;
    public PersistentMoney getMoney() throws PersistenceException ;
    public void setMoney(PersistentMoney newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentDebitNoteTransaction getThis() throws PersistenceException ;
    
    public void accept(DebitNoteTransactionVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitNoteTransactionReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitNoteTransactionExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitNoteTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

