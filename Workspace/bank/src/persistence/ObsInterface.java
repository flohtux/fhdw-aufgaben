package persistence;

import model.UserException;
import model.visitor.ObsInterfaceExceptionVisitor;
import model.visitor.ObsInterfaceReturnExceptionVisitor;
import model.visitor.ObsInterfaceReturnVisitor;
import model.visitor.ObsInterfaceVisitor;


/* Additional import section end */

public interface ObsInterface extends AbstractPersistentProxi {
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

