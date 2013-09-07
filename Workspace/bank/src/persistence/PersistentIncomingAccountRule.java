package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentIncomingAccountRule extends PersistentRule {
    
    public long getAccountNumber() throws PersistenceException ;
    public void setAccountNumber(long newValue) throws PersistenceException ;
    public long getBankNumber() throws PersistenceException ;
    public void setBankNumber(long newValue) throws PersistenceException ;
    public PersistentIncomingAccountRule getThis() throws PersistenceException ;
    
    public void accept(RuleVisitor visitor) throws PersistenceException;
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
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
    public void changeAccountNumber(final long accNum) 
				throws PersistenceException;
    public void changeBankNumber(final long bankNum) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

