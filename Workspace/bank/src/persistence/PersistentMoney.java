package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMoney extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public PersistentAmount getAmount() throws PersistenceException ;
    public void setAmount(PersistentAmount newValue) throws PersistenceException ;
    public PersistentCurrency getCurrency() throws PersistenceException ;
    public void setCurrency(PersistentCurrency newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentMoney getThis() throws PersistenceException ;
    
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
    public PersistentMoney add(final PersistentMoney money) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public PersistentBooleanValue equalsValue(final PersistentMoney money) 
				throws PersistenceException;
    public PersistentBooleanValue greaterOrEqual(final PersistentMoney money) 
				throws PersistenceException;
    public PersistentBooleanValue greater(final PersistentMoney money) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public PersistentMoney multiply(final common.Fraction factor) 
				throws PersistenceException;
    public PersistentMoney subtract(final PersistentMoney money) 
				throws model.LimitViolatedException, PersistenceException;

}

