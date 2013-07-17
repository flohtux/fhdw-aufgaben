package persistence;


/* Additional import section end */

public interface ComponentHierarchyHIERARCHYStrategy<T> {
    
    public T consolidate$$Product$$parts(final PersistentProduct ths, final T result, final T current) 
				throws PersistenceException;
    public T finalize$$Material(final PersistentMaterial ths, final T parameter) 
				throws PersistenceException;
    public T finalize$$Product(final PersistentProduct ths, final T parameter, final T parts) 
				throws PersistenceException;
    public T finalize$$QPart(final PersistentQPart ths, final T parameter, final T component) 
				throws PersistenceException;
    public T initialize$$Product$$parts(final PersistentProduct ths, final T parameter) 
				throws PersistenceException;
    public T initialize$$QPart$$component(final PersistentQPart ths, final T parameter) 
				throws PersistenceException;

    
}

