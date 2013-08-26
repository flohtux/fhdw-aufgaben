package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentDebitTransfer extends PersistentDebitTransferTransaction {
    
    public long getReceiverAccountNumber() throws PersistenceException ;
    public void setReceiverAccountNumber(long newValue) throws PersistenceException ;
    public long getReceiverBankNumber() throws PersistenceException ;
    public void setReceiverBankNumber(long newValue) throws PersistenceException ;
    public PersistentMoney getMoney() throws PersistenceException ;
    public void setMoney(PersistentMoney newValue) throws PersistenceException ;
    public String getSubject() throws PersistenceException ;
    public void setSubject(String newValue) throws PersistenceException ;
    public PersistentStornoState getStornoState() throws PersistenceException ;
    public void setStornoState(PersistentStornoState newValue) throws PersistenceException ;
    public abstract PersistentDebitTransfer getThis() throws PersistenceException ;
    
    public void accept(DebitTransferVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitTransferReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitTransferExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitTransferReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentMoney fetchRealMoney() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

