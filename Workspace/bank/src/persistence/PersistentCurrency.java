package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCurrency extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public abstract PersistentCurrency getThis() throws PersistenceException ;
    
    public void accept(CurrencyVisitor visitor) throws PersistenceException;
    public <R> R accept(CurrencyReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CurrencyExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CurrencyReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

