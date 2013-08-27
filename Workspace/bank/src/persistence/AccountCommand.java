package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface AccountCommand extends  Command {
    

    public void accept(AccountCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AccountCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AccountCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

