package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCached extends PersistentState {
    
    public PersistentMateriallist getCachedList() throws PersistenceException ;
    public void setCachedList(PersistentMateriallist newValue) throws PersistenceException ;
    public PersistentCached getThis() throws PersistenceException ;
    
    public void accept(StateVisitor visitor) throws PersistenceException;
    public <R> R accept(StateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

