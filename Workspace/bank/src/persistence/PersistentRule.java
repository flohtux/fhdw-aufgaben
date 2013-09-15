package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentRule extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentRule getThis() throws PersistenceException ;
    
    public void accept(RuleVisitor visitor) throws PersistenceException;
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentTrigger getMasterTrigger() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public PersistentBooleanValue check(final PersistentDebitTransfer debitTransfer) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

