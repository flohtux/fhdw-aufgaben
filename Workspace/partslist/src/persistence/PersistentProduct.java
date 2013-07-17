package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentProduct extends PersistentComponent {
    
    public Product_PartsProxi getParts() throws PersistenceException ;
    public PersistentProduct getThis() throws PersistenceException ;
    
    public void accept(ComponentVisitor visitor) throws PersistenceException;
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ComponentHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(ComponentHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ComponentHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ComponentHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public boolean containsComponentHierarchy(final ComponentHierarchyHIERARCHY part) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public <T> T strategyComponentHierarchy(final T parameter, final ComponentHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void addComponent(final PersistentComponent newComponent, final long amount) 
				throws model.CycleException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void notifyChangedMateriallist() 
				throws PersistenceException;

}

