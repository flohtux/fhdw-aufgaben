package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentDebitTransferState extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentDebitTransferState getThis() throws PersistenceException ;
    
    public void accept(DebitTransferStateVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentDebitTransferTransaction getDebitTransfer() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addDebitTransferFromList(final PersistentDebitTransferState state) 
				throws PersistenceException;
    public void changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentDebitTransferState copy() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public PersistentBooleanValue isCompensationRequest() 
				throws PersistenceException;
    public PersistentBooleanValue isExecutable() 
				throws PersistenceException;
    public PersistentBooleanValue isTransaction() 
				throws PersistenceException;
    public void removeDebitTransferFromList() 
				throws PersistenceException;

}

