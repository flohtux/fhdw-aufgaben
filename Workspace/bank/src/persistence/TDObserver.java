package persistence;

public interface TDObserver {
    public void updateTransientDerived(persistence.AbstractPersistentRoot objectIndex, String fieldIndex, Object object) throws PersistenceException;
    public void updateTransientDerived(java.util.Vector<Object> operationIndex, Object object) throws PersistenceException;
}

