package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentStornoState extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentStornoState getThis() throws PersistenceException ;
    
    public void accept(StornoStateVisitor visitor) throws PersistenceException;
    public <R> R accept(StornoStateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(StornoStateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(StornoStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentDebitNoteTransfer getDebitNoteTransfer() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

