package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface BankCreatorCommand extends  Command {
    

    public void accept(BankCreatorCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(BankCreatorCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(BankCreatorCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(BankCreatorCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

