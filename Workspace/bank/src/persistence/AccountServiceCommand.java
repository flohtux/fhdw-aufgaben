package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface AccountServiceCommand extends  Command {
    

    public void accept(AccountServiceCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountServiceCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AccountServiceCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AccountServiceCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

