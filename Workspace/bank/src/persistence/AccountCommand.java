package persistence;

import model.UserException;
import model.visitor.AccountCommandExceptionVisitor;
import model.visitor.AccountCommandReturnExceptionVisitor;
import model.visitor.AccountCommandReturnVisitor;
import model.visitor.AccountCommandVisitor;


/* Additional import section end */

public interface AccountCommand extends  Command {
    

    public void accept(AccountCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AccountCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AccountCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

