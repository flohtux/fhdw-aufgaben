package persistence;

import model.UserException;
import model.visitor.DebitTransferTransactionCommandExceptionVisitor;
import model.visitor.DebitTransferTransactionCommandReturnExceptionVisitor;
import model.visitor.DebitTransferTransactionCommandReturnVisitor;
import model.visitor.DebitTransferTransactionCommandVisitor;


/* Additional import section end */

public interface DebitTransferTransactionCommand extends  Command {
    

    public void accept(DebitTransferTransactionCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitTransferTransactionCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitTransferTransactionCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitTransferTransactionCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

