package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentLimitAccount extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public PersistentLimitType getMinLimit() throws PersistenceException ;
    public void setMinLimit(PersistentLimitType newValue) throws PersistenceException ;
    public PersistentLimitType getMaxLimit() throws PersistenceException ;
    public void setMaxLimit(PersistentLimitType newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentLimitAccount getThis() throws PersistenceException ;
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public PersistentAccount getAccount() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void changeMaxLimit(final PersistentMoney money) 
				throws model.MaxLimitLowerThenMinLimitException, PersistenceException;
    public void changeMinLimit(final PersistentMoney money) 
				throws model.MinLimitHigherMaxLimitException, PersistenceException;
    public void checkLimit(final PersistentMoney money) 
				throws model.LimitViolatedException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

