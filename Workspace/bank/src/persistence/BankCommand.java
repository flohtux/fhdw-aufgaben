package persistence;

import model.UserException;
import model.visitor.BankCommandExceptionVisitor;
import model.visitor.BankCommandReturnExceptionVisitor;
import model.visitor.BankCommandReturnVisitor;
import model.visitor.BankCommandVisitor;


/* Additional import section end */

public interface BankCommand extends  Command {
    

    public void accept(BankCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(BankCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(BankCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(BankCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

