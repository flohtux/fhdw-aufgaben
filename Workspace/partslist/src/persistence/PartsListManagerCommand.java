package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface PartsListManagerCommand extends  Command {
    

    public void accept(PartsListManagerCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(PartsListManagerCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(PartsListManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(PartsListManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

