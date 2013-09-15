package persistence;

import model.UserException;
import model.visitor.BankCreatorCommandExceptionVisitor;
import model.visitor.BankCreatorCommandReturnExceptionVisitor;
import model.visitor.BankCreatorCommandReturnVisitor;
import model.visitor.BankCreatorCommandVisitor;


/* Additional import section end */

public interface BankCreatorCommand extends  Command {
    

    public void accept(BankCreatorCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(BankCreatorCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(BankCreatorCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(BankCreatorCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

