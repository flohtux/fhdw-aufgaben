package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMoneyRule extends PersistentRule {
    
    public PersistentCurrency getCurrency() throws PersistenceException ;
    public void setCurrency(PersistentCurrency newValue) throws PersistenceException ;
    public PersistentAmount getMinLimit() throws PersistenceException ;
    public void setMinLimit(PersistentAmount newValue) throws PersistenceException ;
    public PersistentAmount getMaxLimit() throws PersistenceException ;
    public void setMaxLimit(PersistentAmount newValue) throws PersistenceException ;
    public PersistentMoneyRule getThis() throws PersistenceException ;
    
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
    public void changeMax(final common.Fraction maxValue) 
				throws PersistenceException;
    public void changeMin(final common.Fraction minValue) 
				throws PersistenceException;
    public PersistentBooleanValue checkMax(final common.Fraction maxValue) 
				throws PersistenceException;
    public PersistentBooleanValue checkMin(final common.Fraction minValue) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

