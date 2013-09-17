package persistence;

import model.UserException;
import model.visitor.CompensationCommandExceptionVisitor;
import model.visitor.CompensationCommandReturnExceptionVisitor;
import model.visitor.CompensationCommandReturnVisitor;
import model.visitor.CompensationCommandVisitor;


/* Additional import section end */

public interface CompensationCommand extends  Command {
    

    public void accept(CompensationCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(CompensationCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CompensationCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CompensationCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

