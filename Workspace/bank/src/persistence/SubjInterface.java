package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface SubjInterface extends AbstractPersistentProxi {
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException;
    public void register(final ObsInterface observee) 
				throws PersistenceException;
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException;

    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

